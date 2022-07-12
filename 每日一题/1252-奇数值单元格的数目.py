"""
给你一个 m x n 的矩阵，最开始的时候，每个单元格中的值都是 0。

另有一个二维索引数组indices，indices[i] = [ri, ci] 指向矩阵中的某个位置，其中 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。

对 indices[i] 所指向的每个位置，应同时执行下述增量操作：

ri 行上的所有单元格，加 1 。
ci 列上的所有单元格，加 1 。
给你 m、n 和 indices 。请你在执行完所有indices指定的增量操作后，返回矩阵中 奇数值单元格 的数目。


"""
from typing import List


class Solution:
    def oddCells(self, m: int, n: int, indices: List[List[int]]) -> int:
        """
        思路：loop就完事
        :param m: 行
        :param n: 列
        :param indices: 标记
        :return:
        """
        res = 0
        matrix = [[0] * n for _ in range(m)]

        for indice in indices:
            for i in range(n):
                matrix[indice[0]][i] += 1
            print(matrix)
            for i in range(m):
                matrix[i][indice[1]] += 1

        for i in range(m):
            for j in range(n):
                if matrix[i][j] % 2 != 0:
                    res += 1

        return res

    def oddCells2(self, m: int, n: int, indices: List[List[int]]) -> int:
        """
        优化，节省空间，只
        :param m:
        :param n:
        :param indices:
        :return:
        """
        rows = [0] * m
        cols = [0] * n
        for x, y in indices:
            rows[x] += 1
            cols[y] += 1
        return sum((row + col) % 2 for row in rows for col in cols)


if __name__ == '__main__':
    s = Solution()
    s.oddCells2(2,3,[[0,1],[1,1]])



