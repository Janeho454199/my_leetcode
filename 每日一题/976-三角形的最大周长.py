from typing import List


class Solution:
    def largestPerimeter(self, nums: List[int]) -> int:
        """
        三角形的基本性质是两边之和大于第三边；两边之差小于第三边
        """
        nums.sort(reverse=True)
        for i in range(len(nums)-2):
            if (nums[i+2]+nums[i+1]) > nums[i]:
                return nums[i+2]+nums[i+1]+nums[i]

        return 0
