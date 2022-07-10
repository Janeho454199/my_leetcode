from typing import List


class Solution:
    def fillCups(self, amount: List[int]) -> int:
        res = 0
        while amount[0] != 0 or amount[1] != 0 or amount[2] != 0:
            first = 0
            second = 1
            amount.sort(reverse=True)
            print(amount)
            if amount[first] and amount[second]:
                amount[first] -= 1
                amount[second] -= 1
                res += 1
            elif amount[first] and amount[second] == 0:
                amount[first] -= 1
                res += 1
        return res