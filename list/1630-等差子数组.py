from typing import List


class Solution:
    def check_arithmetic(self, sub_array_nums):
        sub_array_nums.sort()
        diff = sub_array_nums[1] - sub_array_nums[0]
        if all(sub_array_nums[i] - sub_array_nums[i - 1] == diff for i in range(2, len(sub_array_nums))):
            return True
        return False

    def checkArithmeticSubarrays(self, nums: List[int], l: List[int], r: List[int]) -> List[bool]:
        """
        思路：暴力
        :param nums:
        :param l:
        :param r:
        :return:
        """
        res = []
        for left, right in zip(l, r):
            if right - left >= 2:
                res.append(self.check_arithmetic(nums[left:right + 1]))
            else:
                res.append(True)

        return res
