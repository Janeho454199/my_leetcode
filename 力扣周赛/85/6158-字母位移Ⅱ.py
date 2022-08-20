import collections
from typing import List


class Solution:
    def shiftingLetters(self, s: str, shifts: List[List[int]]) -> str:
        """
        思路：直接模拟（超时）
        """
        def forward_or_backward(w, flag):
            w = ord(w)
            # 循环
            if flag == 0:
                if w == 97:
                    w = 122
                else:
                    w -= 1
                return chr(w)
            else:
                # 循环
                if w == 122:
                    w = 97
                else:
                    w += 1
                return chr(w)

        s = list(s)

        for change in shifts:
            start = change[0]
            end = change[1]
            # 0为向前，1为向后
            flag = change[2]
            for i in range(start, end + 1):
                s[i] = forward_or_backward(s[i], flag)

        return ''.join(s)

    def shiftingLetters2(self, s: str, shifts: List[List[int]]) -> str:
        """
        大佬的题解
        使用差分数组计算每个位置总共左移或者右移的位数，与现有的加和后取模得到最终的字符
        """
        n = len(s)
        diff = [0] * n
        for i, j, d in shifts:
            if d == 1:
                if j + 1 < n:
                    diff[j + 1] -= 1
                diff[i] += 1
            else:
                if j + 1 < n:
                    diff[j + 1] += 1
                diff[i] -= 1
        # 计算每个位置的移动位数
        lst = [diff[0]]
        for d in diff[1:]:
            lst.append(lst[-1] + d)
        # 获取变换结果
        ans = []
        for w in s:
            ans.append(ord(w) - ord('a'))
        for i in range(n):
            ans[i] = (ans[i] + lst[i]) % 26
        word = "abcdefghijklmnopqrstuvwxyz"
        ans = [word[i] for i in ans]
        return "".join(ans)


if __name__ == '__main__':
    s = Solution()
    print(s.shiftingLetters2(s = "abc", shifts = [[0,1,0],[1,2,1],[0,2,1]]))