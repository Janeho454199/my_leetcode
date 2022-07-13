"""
给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。

请返回 nums 的动态和。

"""
from typing import List


class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        if nums is None:
            return []
        res = [nums[0]]
        for i in range(1, len(nums)):
            res.append(res[i-1] + nums[i])

        return res
