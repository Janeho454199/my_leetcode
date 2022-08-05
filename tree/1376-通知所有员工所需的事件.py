import collections
from typing import List


class Solution:
    def numOfMinutes(self, n: int, headID: int, manager: List[int], informTime: List[int]) -> int:
        graph = collections.defaultdict(list)
        # 遍历manager，统计每一位领导下面的员工以及对该员工发送紧急消息所花费的时间
        for i, leader in enumerate(manager):
            graph[leader].append((i, informTime[i]))

        # dfs，寻找每一层通知需要花费的最大时间
        def recur(curr):
            # curr为当前节点
            # j为其手下的其中一名员工，t为发送消息所花费的时间，取最大值
            temp = 0
            for j, t in graph[curr]:
                temp = max(temp, recur(j) + t)
            return temp

        return recur(-1)


if __name__ == '__main__':
    s = Solution()
    s.numOfMinutes(6,2,[2,2,-1,2,2,2],[0,0,1,0,0,0])