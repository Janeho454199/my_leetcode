"""
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

示例 1：
输入：n = 2
输出：2
解释：有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶

示例 2：
输入：n = 3
输出：3
解释：有三种方法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶
"""


class Solution:
    def climbStairs(self, n: int) -> int:
        """
        每一次只能从上一次跳1步或者跳两步的来
        即 f(x) = f(x - 1) + f(x - 2)
        dp公式 = dp[i] = dp[i -1 ] + dp[i - 2]
        :param n:
        :return:
        """
        if n == 0:
            return 0
        if n == 1:
            return 1

        dp = [1, 2]

        for i in range(2, n):
            dp.append(dp.pop(0) + dp[0])

        return dp[-1]


if __name__ == '__main__':
    s = Solution()
    s.climbStairs(4)
