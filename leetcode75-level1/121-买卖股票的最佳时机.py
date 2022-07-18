import sys


class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        min_price = sys.maxsize
        res = 0
        for i in prices:
            min_price = min(min_price, i)
            res = max(res, i - min_price)

        return res
