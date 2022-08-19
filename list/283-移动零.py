from typing import List


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        """
        思路：双指针，左指针指向非零元素，right指向当前已经发现的零的前一位元素
        1 2 0 3 4 0 5 6
        """
        if len(nums) == 0 or len(nums) == 1:
            return

        left = 0
        right = 0

        while right < len(nums):
            # 当前没找到零
            if nums[left] != 0:
                right += 1
                left += 1
                continue
            # 双指针相遇
            if left == right:
                right += 1

            # 当找到零
            elif nums[left] == 0 and nums[right] != 0:
                nums[left], nums[right] = nums[right], nums[left]
                left += 1
                right += 1
            # 当左指针找到零，但又指针为零的时候，往右找非零元素
            else:
                right += 1

