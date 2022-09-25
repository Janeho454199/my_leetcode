from typing import List


class Solution:
    def sortPeople(self, names: List[str], heights: List[int]) -> List[str]:
        res = []
        name_index = {}
        # 制作身高下标字典
        for _ in range(len(heights)):
            name_index[heights[_]] = _

        heights.sort(reverse=True)

        for height in heights:
            res.append(names[name_index[height]])

        return res


if __name__ == '__main__':
    s = Solution()
    print(s.sortPeople(["Alice","Bob","Bob"], [155,185,150]))