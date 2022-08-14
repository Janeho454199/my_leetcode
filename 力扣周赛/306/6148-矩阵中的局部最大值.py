from typing import List


class Solution:
    def largestLocal(self, grid: List[List[int]]) -> List[List[int]]:
        """
        loop就完事！
        """
        res = [[0] * (len(grid[0]) - 2) for _ in range(len(grid) - 2)]
        n = len(grid) - 2

        for i in range(1, n + 1):
            for j in range(1, n + 1):
                # 遍历九宫格
                for row in [i - 1, i, i + 1]:
                    for col in [j - 1, j, j + 1]:
                        res[i - 1][j - 1] = max(res[i - 1][j - 1], grid[row][col])

        return res


if __name__ == '__main__':
    s = Solution()
    print(s.largestLocal([[9,9,8],[5,6,2],[8,2,6]]))