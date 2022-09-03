from itertools import combinations
from typing import List


class Solution:
    def maximumRows(self, mat: List[List[int]], cols: int) -> int:
        """
        由于数据规模比较小，预先存好每行为11的列号
        直接采用暴力枚举的方式进行判断即可，Python3有库函数combinations可直接进行枚举
        """
        m, n = len(mat), len(mat[0])
        # 预先存好对应的列号
        row = [set() for _ in range(m)]
        for i in range(m):
            for j in range(n):
                if mat[i][j]:
                    row[i].add(j)

        ans = 0
        print(list(range(n)))
        # 枚举组合, combinations:从可迭代对象iterable中选取r个单位进行组合
        for item in combinations(list(range(n)), cols):
            cur = set(list(item))
            cnt = 0
            for i in range(m):
                # set的一个方法，返回一个新集合，集合的元素为交集
                if len(row[i].intersection(cur)) == len(row[i]):
                    cnt += 1
            if cnt > ans:
                ans = cnt
        return ans


if __name__ == '__main__':
    s = Solution()
    # print(s.maximumRows([[1,0,0,0,0,0,0],[0,1,0,1,1,1,1],[0,0,0,1,0,0,1]], 5))
    print(s.maximumRows([[1,0,1,1,1,1],[0,0,0,1,1,0],[1,1,0,0,0,0],[0,0,1,1,0,1]], 2))

