import collections
from typing import List


class Solution:
    def reachableNodes(self, n: int, edges: List[List[int]], restricted: List[int]) -> int:
        """
        DFS
        :param n:
        :param edges:
        :param restricted:
        :return:
        """
        visited = set()
        restricted = set(restricted)
        visited.add(0)

        graph = collections.defaultdict(list)
        for edge in edges:
            graph[edge[0]].append(edge[1])
            graph[edge[1]].append(edge[0])

        def dfs(curr, visited):
            # curr为当前节点
            route = graph[curr]
            for i in route:
                if i not in restricted and curr not in restricted:
                    if i not in visited:
                        visited.add(i)
                        dfs(i, visited)
                    elif curr not in visited:
                        visited.add(curr)
                        dfs(i, visited)

        dfs(0, visited)

        return len(visited)

    def reachableNodes2(self, n: int, edges: List[List[int]], restricted: List[int]) -> int:
        """
        BFS
        :param n:
        :param edges:
        :param restricted:
        :return:
        """
        graph = collections.defaultdict(set)
        for a, b in edges:
            graph[a].add(b)
            graph[b].add(a)

        visited = set(restricted)

        stack = [0]
        ans = 0

        while stack:
            curr = stack.pop()
            if curr in visited:
                continue
            visited.add(curr)
            ans += 1

            for v in graph[curr]:
                stack.append(v)

        return ans
