class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        """
        思路：我们将两个 s 连在一起，并移除第一个和最后一个字符。如果 s 是该字符串的子串，那么 s 就满足题目要求
        :param s:
        :return:
        """
        return (s + s).find(s, 1) != len(s)

