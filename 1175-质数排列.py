"""
请你帮忙给从 1 到 n的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
由于答案可能会很大，所以请你返回答案 模 mod10^9 + 7之后的结果即可。

示例 1：
输入：n = 5
输出：12
解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。

示例 2：
输入：n = 100
输出：682289015
"""
import math


class Solution:
    """
    思路：
    ①找出1~n质数
    ②质数与非质数位置进行排列组合
    ③相乘即可获得最终的结果
    """
    def numPrimeArrangements(self, n):
        mod = 10 ** 9 + 7
        res, num = 1, 0
        # 简单判断计算质数个数，质数都是由这几个基础质数[2, 3, 5, 7]组成的，由此我们可以得到简单易懂的判断方法
        # 注意的点：1为合数

        for i in range(1, n + 1):
            if self.is_prime(i):
                continue
            num += 1

        # 质数全排列，合数位置固定
        for j in range(1, num + 1):
            res *= j

        # 合数全排列，质数位置固定
        for k in range(1, n - num + 1):
            res *= k

        return res % mod

    def is_prime(self, num):
        """
        判断是否是质数
        :param num: 整数
        :return: T/F
        """
        if num <= 1:
            return False
        for i in range(2, int(math.sqrt(num)) + 1):
            if num % i == 0:
                return False

        return True


if __name__ == '__main__':
    tt = Solution()
    print(tt.numPrimeArrangements(100))
