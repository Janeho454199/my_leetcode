from typing import List


class Solution:
    def minStartValue(self, nums: List[int]) -> int:
        start_value = 1
        min_sum = 0
        count = 0
        for i in nums:
            count += i
            if count < min_sum:
                min_sum = count

        return start_value - min_sum