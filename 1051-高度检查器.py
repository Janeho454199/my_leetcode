"""
学校打算为全体学生拍一张年度纪念照。根据要求，学生需要按照 非递减 的高度顺序排成一行。

排序后的高度情况用整数数组 expected 表示，其中 expected[i] 是预计排在这一行中第 i 位的学生的高度（下标从 0 开始）。

给你一个整数数组 heights ，表示 当前学生站位 的高度情况。heights[i] 是这一行中第 i 位学生的高度（下标从 0 开始）。

返回满足 heights[i] != expected[i] 的 下标数量 。
"""


class Solution:
    def heightChecker(self, heights) -> int:
        expected = list.copy(heights)
        expected.sort()
        count = 0
        print(heights)
        print(expected)

        for i in range(len(heights)):
            if heights[i] != expected[i]:
                count += 1

        return count

    def heightChecker2(self, heights) -> int:
        if len(heights) == 1:
            return 0
        expected = [0 for i in range(101)]
        for i in heights:
            expected[i] += 1

        count = 0
        j = 0

        for i in range(1, len(expected)):
            while expected[i] > 0:
                expected[i] -= 1
                if heights[j] != i:
                    count += 1
                j += 1

        return count


if __name__ == '__main__':
    s = Solution()
    print(s.heightChecker2([2,1,2,5,6,7]))