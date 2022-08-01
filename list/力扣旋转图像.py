from typing import List


class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        使用辅助变量
        :param matrix:
        :return:
        """
        # 设矩阵行列数为 n
        n = len(matrix)
        # 起始点范围为 0 <= i < n // 2 , 0 <= j < (n + 1) // 2
        # 其中 '//' 为整数除法
        for i in range(n // 2):
            for j in range((n + 1) // 2):
                # 暂存 A 至 tmp
                tmp = matrix[i][j]
                # 元素旋转操作 A <- D <- C <- B <- tmp
                matrix[i][j] = matrix[n - 1 - j][i]
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]
                matrix[j][n - 1 - i] = tmp

    def rotate2(self, matrix: List[List[int]]) -> None:
        """
        两次翻转：上下翻转+主对角线翻转
        :param matrix:
        :return:
        """
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        for i in range(n):
            # 注意这里j的范围 如果j的范围也是0到n-1那么会出现交换后又交换回来 等于没有交换
            for j in range(i):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]

        for line in matrix:
            line.reverse()
