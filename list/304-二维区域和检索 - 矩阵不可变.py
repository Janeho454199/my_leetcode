from typing import List


class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        """
        S(O,D)=S(O,C)+S(O,B)−S(O,A)+D
        S(A,D)=S(O,D)−S(O,E)−S(O,F)+S(O,G)
        preSum[row2][col2]−preSum[row2][col1−1]−preSum[row1−1][col2]+preSum[row1−1][col1−1]
        :param matrix:
        """
        if not matrix or not matrix[0]:
            M, N = 0, 0
        else:
            M, N = len(matrix), len(matrix[0])

        # 生成前缀和矩阵
        self.preSum = [[0] * (N + 1) for _ in range(M + 1)]
        for i in range(M):
            for j in range(N):
                self.preSum[i + 1][j + 1] = self.preSum[i][j + 1] + self.preSum[i + 1][j] - self.preSum[i][j] + matrix[i][j]

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        return self.preSum[row2 + 1][col2 + 1] - self.preSum[row2 + 1][col1] - self.preSum[row1][col2 + 1] + self.preSum[row1][col1]
