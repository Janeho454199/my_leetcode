class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        """
        思路：动态规划
        公式：load[m][n] = load[m-1][n] + load[m][n-1]
        """

        load = [[0] * n for _ in range(m)]

        for i in range(m):
            for j in range(n):
                # 第一行第一列都只有1
                if i == 0 or j == 0:
                    load[i][j] = 1
                load[i][j] = load[i - 1][j] + load[i][j - 1]

        return load[-1][-1]


if __name__ == '__main__':
    s = Solution()
    s.uniquePaths(3, 7)