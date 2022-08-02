from typing import List


class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        """
        思路：一层一层遍历
        :param matrix:
        :return:
        """
        if not matrix or not matrix[0]: return []
        M, N = len(matrix), len(matrix[0])
        # 四个边界
        left, right, up, down = 0, N - 1, 0, M - 1
        # 结果
        res = []
        # 初始位置
        x, y = 0, 0
        # 控制方向
        dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        # 当前方向
        cur_d = 0
        while len(res) != M*N:
            res.append(matrix[x][y])
            # 到达右边界
            if cur_d == 0 and y == right:
                cur_d += 1
                up += 1
            # 到达下边界
            elif cur_d == 1 and x == down:
                cur_d += 1
                right -= 1
            # 到达左边界
            elif cur_d == 2 and y == left:
                cur_d += 1
                down -= 1
            # 到达上边界
            elif cur_d == 3 and x == up:
                cur_d += 1
                left += 1
            cur_d %= 4
            x += dirs[cur_d][0]
            y += dirs[cur_d][1]
        return res


