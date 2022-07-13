import sys
from typing import List


class Solution:
    def nearestValidPoint(self, x: int, y: int, points: List[List[int]]) -> int:
        res = -1
        temp = sys.maxsize
        for i in range(len(points)):
            if points[i][0] == x or points[i][1] == y:
                if (abs(points[i][0]-x) + abs(points[i][1]-y)) < temp:
                    temp = abs(points[i][0]-x) + abs(points[i][1]-y)
                    res = i

        return res


if __name__ == '__main__':
    s = Solution()
    s.nearestValidPoint(3,
4,
[[2,3]])