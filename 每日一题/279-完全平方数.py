"""
思路：BFS

BFS通用基本框架
queue = [起始点]    # 队列实现BFS
visited = set()    # 记录访问过的元素点，避免“回头”访问，陷入循环
visited.add(起始点)
step = 0
while queue:
    # 将所有节点同时向前扩散一步
    for _ in range(len(queue)):
        cur = queue.pop(0)
        if 找到目标:
            return 结果
        # 将cur的【所有相邻且没被访问过的节点】加入队列
        for near in cur的邻近节点：
            if near not in visited:
                queue.append(near)
                visited.add(near)
    step += 1    # 记录路径长度
"""
import math

import queue


class Solution:
    def numSquares(self, n):
        q = queue.Queue()
        count = 1
        kv = {}
        while q.qsize() and


