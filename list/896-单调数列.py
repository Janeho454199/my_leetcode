from typing import List


class Solution:
    def isMonotonic(self, nums: List[int]) -> bool:
        n = len(nums)
        ascend = 0
        descend = 0
        for i in range(n-1):
            if nums[i] < nums[i+1]:
                ascend += 1
            if nums[i] > nums[i+1]:
                descend += 1
            if ascend and descend:
                return False
        return True
