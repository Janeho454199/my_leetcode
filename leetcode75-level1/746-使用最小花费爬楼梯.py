from typing import List


class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        """
        思路：动态规划
        公式：dp[i] = dp[i - 1] + cost[i] or dp[i - 2] + cost[i - 2]
        """
        n = len(cost)

        dp = [0] * n
        dp[0], dp[1] = cost[0], cost[1]

        for i in range(2, n):
            dp[i] = min(dp[i - 2], dp[i - 1]) + cost[i]
        return min(dp[-2], dp[-1])

    def minCostClimbingStairs2(self, cost: List[int]) -> int:
        """
        上面的方法基础上优化空间
        """
        for i in range(2, len(cost)):
            cost[i] = min(cost[i - 2], cost[i - 1]) + cost[i]
        return min(cost[-2], cost[-1])
