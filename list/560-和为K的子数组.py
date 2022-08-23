import collections
from typing import List


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        """
        前缀和+hashmap
        """
        hash_map = collections.defaultdict(int)
        hash_map[0] = 1
        cur_sum = 0
        res = 0

        for i in range(len(nums)):
            cur_sum += nums[i]
            target = cur_sum - k
            if target in hash_map.keys():
                res += hash_map[target]
            hash_map[cur_sum] += 1

        return res


if __name__ == '__main__':
    s = Solution()
    print(s.subarraySum([1,2,3], 3))