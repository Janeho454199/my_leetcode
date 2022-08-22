from typing import List


class Solution:

    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:

        def dfs(graph, cur, visit):
            visit.append(cur)
            if cur == len(graph) - 1:
                res.append(list(visit))
            for i in graph[cur]:
                dfs(graph, i, visit)
            visit.pop(-1)
        res = []
        visit = []
        dfs(graph, 0, visit)
        return res
