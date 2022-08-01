from typing import List


class Solution:
    def findRotation(self, mat: List[List[int]], target: List[List[int]]) -> bool:
        n = len(mat)
        if mat == target:
            return True
        # 起始点范围为 0 <= i < n // 2 , 0 <= j < (n + 1) // 2
        # 其中 '//' 为整数除法
        for k in range(4):
            for i in range(n // 2):
                for j in range((n + 1) // 2):
                    # 暂存 A 至 tmp
                    tmp = mat[i][j]
                    # 元素旋转操作 A <- D <- C <- B <- tmp
                    mat[i][j] = mat[n - 1 - j][i]
                    mat[n - 1 - j][i] = mat[n - 1 - i][n - 1 - j]
                    mat[n - 1 - i][n - 1 - j] = mat[j][n - 1 - i]
                    mat[j][n - 1 - i] = tmp
            if mat == target:
                return True

        return False
