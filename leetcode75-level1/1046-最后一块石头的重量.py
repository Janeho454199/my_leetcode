import heapq
import queue
from typing import List


class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        q = queue.PriorityQueue()
        for i in stones:
            q.put(-i)

        while q.qsize() > 1:
            x = q.get()
            y = q.get()

            if x == y:
                continue
            else:
                q.put(-abs(x - y))

        if q.empty():
            return 0
        else:
            return -1 * q.get()


if __name__ == '__main__':
    s = Solution()
    s.lastStoneWeight([2,7,4,1,8,1])