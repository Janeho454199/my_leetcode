"""
给定一个数组points，其中points[i] = [xi, yi]表示 X-Y 平面上的一个点，如果这些点构成一个回旋镖则返回true。

回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。


示例 1：
输入：points = [[1,1],[2,3],[3,2]]
输出：true

示例 2：
输入：points = [[1,1],[2,2],[3,3]]
输出：false

思路：形成三角形，两线之间斜率不相等
即 X2-X1/Y2-Y1 != X3-X1/Y3-Y1

"""


class Solution:
    def isBoomerang(self, points) -> bool:
        return (points[0][0] - points[1][0]) * (points[0][1] - points[2][1]) != (points[0][1] - points[1][1]) * (
                    points[0][0] - points[2][0])