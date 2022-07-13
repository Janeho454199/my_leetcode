from typing import List


class Solution:
    def arraySign(self, nums: List[int]) -> int:
        temp = 1
        for i in nums:
            temp *= i

        if temp > 1:
            return 1
        elif temp < 0:
            return -1
        else:
            return 0