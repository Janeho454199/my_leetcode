import collections
from typing import List


class Solution:
    def reachableNodes(self, n: int, edges: List[List[int]], restricted: List[int]) -> int:
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


if __name__ == '__main__':
    s = Solution()
    print(s.reachableNodes(10,
[[8,2],[2,5],[5,0],[2,7],[1,7],[3,8],[0,4],[3,9],[1,6]],
[9,8,4,5,3,1]))