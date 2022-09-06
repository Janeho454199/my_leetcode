# -*- coding: utf-8 -*-
"""
给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。

计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。

你可以认为每种硬币的数量是无限的。

示例1：
输入：coins = [1, 2, 5], amount = 11
输出：3
解释：11 = 5 + 5 + 1
示例 2：
输入：coins = [2], amount = 3
输出：-1
示例 3：
输入：coins = [1], amount = 0
输出：0
"""
import sys
from typing import List


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        """
        思路：自顶向下递归，找到满足的硬币数，如果不优化重复路径会超时
        :param coins:
        :param amount:
        :return:
        """
        return self.dp(coins, amount)

    def dp(self, coins: List[int], amount: int) -> int:
        # 凑够了硬币，返回0
        if amount == 0:
            return 0
        # 无法凑齐，返回-1
        if amount < 0:
            return -1

        res = sys.maxsize

        for coin in coins:
            tmp = self.dp(coins, amount - coin)
            if tmp == -1:
                continue
            res = min(res, tmp + 1)

        return -1 if res == sys.maxsize else res


if __name__ == '__main__':
    s = Solution()
    print(s.coinChange(coins=[1, 2, 5], amount=11))
