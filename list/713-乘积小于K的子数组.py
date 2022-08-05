from typing import List


class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        """
        思路：滑动窗口
        当窗口内的值大于k，则左指针右移（left <= right）直到小于k，且每一次窗口内值都windows_value //= nums[left]
        当窗口内的值小于k，则右指针右移（right <= len(nums)），且windows_value *= nums[left]
        :param nums:
        :param k:
        :return:
        """
        if k <= 1:
            return 0

        res, prod = 0, 1
        left = 0
        right = 0

        while right < len(nums):
            prod *= nums[right]

            while prod >= k:
                prod //= nums[left]
                left += 1
            res += right - left + 1
            right += 1

        return res


