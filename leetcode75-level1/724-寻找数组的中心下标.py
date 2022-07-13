from typing import List


class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        pre_sum, total = 0, sum(nums)
        for i in range(len(nums)):
            if total - nums[i] == pre_sum * 2:
                return i
            pre_sum += nums[i]
        return -1