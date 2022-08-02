from heapq import heappush, heappop
from typing import List


class Solution:
    def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
        queue = []
        # 计算欧几里得距离
        distance = lambda x: points[x][0]**2 + points[x][1]**2
        length = len(points)
        # 构造堆排序
        for i in range(length):
            heappush(queue, (distance(i), points[i]))
        res = []
        # 返回
        for i in range(K):
            res.append(heappop(queue)[1])
        return res
