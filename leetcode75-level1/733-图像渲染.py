import copy
from typing import List


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        """
        思路： 模拟+广度优先搜索
        :param image:
        :param sr:
        :param sc:
        :param color:
        :return:
        """
        rows = len(image)
        cols = len(image[0])

        # 如果初始点不在画布内
        if sr >= rows or sc >= cols:
            return image

        # 记录初始点(列表可变对象，必须深拷贝以创建新对象)
        flag = copy.deepcopy(image[sr][sc])

        stack = [[sr, sc]]
        visited = [[sr, sc]]

        while stack:
            r, c = stack.pop()
            # 染色
            if image[r][c] != color:
                image[r][c] = color

            # 上
            if r - 1 >= 0:
                if image[r - 1][c] == flag:
                    if [r - 1, c] not in visited:
                        stack.append([r - 1, c])
                        visited.append([r - 1, c])
            # 下
            if r + 1 < rows:
                if image[r + 1][c] == flag:
                    if [r + 1, c] not in visited:
                        stack.append([r + 1, c])
                        visited.append([r + 1, c])
            # 左
            if c - 1 >= 0:
                if image[r][c - 1] == flag:
                    if [r, c - 1] not in visited:
                        stack.append([r, c - 1])
                        visited.append([r, c - 1])
            # 右
            if c + 1 < cols:
                if image[r][c + 1] == flag:
                    if [r, c + 1] not in visited:
                        stack.append([r, c + 1])
                        visited.append([r, c + 1])

        return image


if __name__ == '__main__':
    s = Solution()
    s.floodFill([[0,0,0],[0,0,0]], 0, 0, 2)
