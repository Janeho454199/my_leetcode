"""
珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有piles[i]根香蕉。警卫已经离开了，将在 h 小时后回来。

珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。

如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。

珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。

返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。

输入：piles = [3, 6, 7, 11], h = 8
输出：4

输入：piles = [30, 11, 23, 4, 20], h = 6
输出：23

1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109
"""
import math


class Solution(object):
    def minEatingSpeed(self, piles, h):
        """
        :type piles: List[int]
        :type h: int
        :rtype: int
        """

        def cost_time(k):
            """
            计算该速度能否满足时间要求
            :param k: int 吃饭速度:
            :return: int
            """

            cost = 0
            for pile in piles:
                cost += math.ceil(pile/k)
            return cost <= h

        left = 1
        right = max(piles)

        while left < right:
            mid = (left+right)//2
            if cost_time(mid):
                right = mid
            else:
                left = mid + 1

        return right


if __name__ == '__main__':
    s = Solution()
    print(s.minEatingSpeed([3, 6, 7, 11], 8))
