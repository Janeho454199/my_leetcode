import collections
from typing import List


class Solution:
    def mergeSimilarItems(self, items1: List[List[int]], items2: List[List[int]]) -> List[List[int]]:
        res = []
        hash_dict = collections.defaultdict(int)

        for item in items1:
            hash_dict[item[0]] += item[1]

        for item in items2:
            hash_dict[item[0]] += item[1]

        hash_dict = sorted(hash_dict.items(), key=lambda x: x[0])

        for i in hash_dict:
            res.append([i[0], i[1]])

        return res


if __name__ == '__main__':
    s = Solution()
    s.mergeSimilarItems(items1 = [[1, 3]], items2 = [])