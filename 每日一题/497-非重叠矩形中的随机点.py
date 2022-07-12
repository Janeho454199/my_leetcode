"""
思路：水塘抽样
关键在于所有的点被抽到的概率需要一致
如果想要公平的选中一个长方形，选中当前长方形的概率应该为当前点数除以总点数，因此当前长方形被选中的概率应该为cur/curSum。
rand()%curSum < cur
"""
import random


class Solution:
    def __init__(self, rects):
        self.recs = rects

    def pick(self):
        cur_sum = 0
        idx = 0
        for i, (a, b, x, y) in enumerate(self.recs):
            cur = (x - a + 1) * (y - b + 1)
            cur_sum += cur
            if random.randint(0, cur_sum) < cur:
                idx = i
        a, b, x, y = self.recs[idx]
        return [random.randint(a, x), random.randint(b, y)]
