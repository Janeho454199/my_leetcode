from typing import List


class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        # digits[i] % 10 取余数，既如果不为10则直接返回，否则上一位进一直到循环出结果或者为999的时候
        for i in range(len(digits)-1, -1, -1):
            digits[i] += 1
            digits[i] = digits[i] % 10
            if digits[i] != 0:
                return digits
        digits.insert(0, 1)
        return digits
