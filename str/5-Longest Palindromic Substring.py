"""
回文串:正读和反读都一样的字符串(可以理解为对称的字符串)
思路: 1 分为奇数串('aba')和偶数串(’abba‘)两种情况
    2 把每个字符当做回文串中间的字符，由内向外延展比较
    (定义由内向外的两个索引值)
"""


class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""
        for i in range(len(s)):
            # 奇数情况
            tmp = self.helper(s, i, i)
            if len(tmp) > len(res):
                res = tmp
            # 偶数情况
            tmp = self.helper(s, i, i + 1)
            if len(tmp) > len(res):
                res = tmp
        return res

    def helper(self, s, l, r):
        while l >= 0 and r < len(s) and s[l] == s[r]:
            l -= 1
            r += 1
        return s[l + 1:r]
