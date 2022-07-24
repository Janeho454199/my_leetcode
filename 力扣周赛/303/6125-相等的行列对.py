from typing import List


class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        res = 0
        rows = len(grid)
        cols = len(grid[0])

        rows_str = [tuple(row) for row in grid]
        cols_str = [tuple([grid[row][col] for row in range(rows)]) for col in range(cols)]

        for i in rows_str:
            if i in cols_str:
                res += cols_str.count(i)

        # for row in range(rows):
        #     for col in range(cols):


        return res


if __name__ == '__main__':
    s = Solution()
    print(s.equalPairs([[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]))
