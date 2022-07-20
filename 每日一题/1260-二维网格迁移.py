class Solution(object):
    def shiftGrid(self, grid, k):
        """
        原来的(i, j)(i,j)对应的一维坐标为i * n + j
        那么平移后为i * n + j + k
        最终坐标为(i∗n+j+k) % (m * n)
        :type grid: List[List[int]]
        :type k: int
        :rtype: List[List[int]]
        """
        n = len(grid)
        m = len(grid[0])
        # 转一维取实际移动距离
        k = k % (m * n)

        res = [[0] * m for _ in range(n)]

        for r in range(n):
            for c in range(m):
                # divmod: 返回一个包含商和余数的元组
                x, y = divmod(r * m + c + k, m)
                res[x % n][y] = grid[r][c]

        return res


if __name__ == '__main__':
    s = Solution()
    s.shiftGrid([[1],[2],[3],[4],[7],[6],[5]], 23)