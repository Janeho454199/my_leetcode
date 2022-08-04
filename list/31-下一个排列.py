from typing import List


class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # 如果数组是逆序排列，直接返回逆序结果，因为逆序排列的数组下一个排列就是他的逆序
        if sorted(nums, reverse=True) == nums:
            nums[:] = nums[::-1]
            return

        # 找到非逆序点
        # 从后向前遍历
        i = len(nums) - 2
        while i >= 0:
            if nums[i] < nums[i + 1]:
                break
            i -= 1

        # 从后往前，找到第一个比nums[i]大的数并交换
        j = len(nums) - 1
        while j >= 0 and nums[i] >= nums[j]:
            j -= 1
        nums[i], nums[j] = nums[j], nums[i]
        # 将i后面的数组翻转
        nums[i + 1:] = nums[i+1:][::-1]
        return
