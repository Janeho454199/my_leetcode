import sys
from typing import List


class Solution:
    def smallestRangeII(self, nums: List[int], k: int) -> int:
        nums = sorted(nums)

        # 整个列表统一加或者减k
        res = nums[-1] - nums[0]

        for i in range(len(nums) - 1):
            top = max(nums[i] + k, nums[-1] - k)
            bottom = min(nums[0] + k, nums[i + 1] - k)
            dif = top - bottom
            res = min(res, dif)

        return res


if __name__ == '__main__':
    s = Solution()
    s.smallestRangeII([2,7,2],1)