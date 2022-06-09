"""
两种方法：深度优先，广度优先
"""


class Solution:
    def numIslands(self, grid):
        """
        广度优先搜索
        :param grid:
        :return:
        """
        if grid is None or len(grid) == 0:
            return 0

        res = 0
        nr = len(grid)
        nc = len(grid[0])

        for r in range(nr):
            for c in range(nc):
                if grid[r][c] == '1':
                    res += 1
                    q = [[r, c]]
                    while q:
                        cur = q.pop(0)
                        if 0 <= cur[0] < len(grid) and 0 <= cur[1] < len(grid[0]) and grid[cur[0]][cur[1]] == '1':
                            grid[cur[0]][cur[1]] = '0'
                            q += [[cur[0] + 1, cur[1]], [cur[0] - 1, cur[1]], [cur[0], cur[1] - 1], [cur[0], cur[1] + 1]]

        return res

    def numIslands_dfs(self, grid):
        """
        深度优先搜索
        :param grid:
        :return:
        """
        if grid is None or len(grid) == 0:
            return 0

        nr = len(grid)
        nc = len(grid[0])

        res = 0

        for i in range(nr):
            for j in range(nc):
                if grid[i][j] == '1':
                    res += 1
                    self.dfs(grid, i, j)

        return res

    def dfs(self, grid, i, j):
        nr = len(grid)
        nc = len(grid[0])
        if i < 0 or j < 0 or i >= nr or j >= nc or grid[i][j] == '0':
            return
        grid[i][j] = '0'
        self.dfs(grid, i + 1, j)
        self.dfs(grid, i - 1, j)
        self.dfs(grid, i, j + 1)
        self.dfs(grid, i, j - 1)
