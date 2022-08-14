import collections
from typing import List


class Solution:
    def edgeScore(self, edges: List[int]) -> int:
        hash_table = collections.defaultdict(int)
        max_value = 0
        res = 0

        for i in range(len(edges)):
            hash_table[edges[i]] += i
            if hash_table[edges[i]] > max_value:
                max_value = hash_table[edges[i]]
                res = edges[i]
            elif hash_table[edges[i]] == max_value and edges[i] < res:
                res = edges[i]

        return res


if __name__ == '__main__':
    s = Solution()
    print(s.edgeScore([2,0,0,2]))