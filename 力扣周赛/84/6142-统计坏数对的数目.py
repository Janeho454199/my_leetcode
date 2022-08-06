from collections import defaultdict
from typing import List


class Solution:
    def countBadPairs(self, nums: List[int]) -> int:
        """
        思路①：暴力loop
        """
        res = 0
        n = len(nums)
        if n == 1:
            return res

        for i in range(n - 1):
            for j in range(i + 1, n):
                if nums[j] - nums[i] != j - i:
                    res += 1

        return res

    def countBadPairs2(self, nums: List[int]) -> int:
        """
        大佬的写法
        """
        d = defaultdict(int)
        ans = len(nums) * (len(nums) - 1) // 2
        for idx, num in enumerate(nums):
            ans -= d[num-idx]
            d[num-idx] += 1
        return ans


if __name__ == '__main__':
    s = Solution()
    print(s.countBadPairs([4,1,3,3,6,8,9,9,5,6,345,23,234,234]))