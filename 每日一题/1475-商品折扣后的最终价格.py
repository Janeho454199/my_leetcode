"""
给你一个数组prices，其中prices[i]是商店里第i件商品的价格。

商店里正在进行促销活动，如果你要买第i件商品，那么你可以得到与 prices[j] 相等的折扣，其中j是满足j > i且prices[j] <= prices[i]的最小下标，如果没有满足条件的j，你将没有任何折扣。

请你返回一个数组，数组中第i个元素是折扣后你购买商品 i最终需要支付的价格。
"""
from typing import List


class Solution:
    def finalPrices(self, prices: List[int]) -> List[int]:
        """
        暴力
        """
        res = []
        n = len(prices)

        for i in range(n):
            temp = prices[i]

            for j in range(i + 1, n):
                if prices[j] <= temp:
                    temp = temp - prices[j]
                    break

            res.append(temp)

        return res

    def finalPrices2(self, prices: List[int]) -> List[int]:
        """
        单调栈
        """
        res = prices.copy()
        n = len(prices)
        stack = [0]
        for i in range(n - 1, -1, -1):
            while prices[i] < stack[-1]:
                stack.pop()
            res[i] = prices[i] - stack[-1]
            stack.append(prices[i])
        return res


if __name__ == '__main__':
    s = Solution()
    print(s.finalPrices2([8, 4, 6, 2, 3]))
