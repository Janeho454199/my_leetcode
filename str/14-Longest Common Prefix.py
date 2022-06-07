"""
思路：选取第一个字符串作为最长串，遍历字符串列表，寻找最长字串
最长字串查找方法：
选取最短的比较串，不停的对比两串之间相同的部分，直到结束或者遇到不相同的部分作为当前最长公共串
"""


class Solution:
    def longestCommonPrefix(self, strs) -> str:
        if not strs:
            return ""

        prefix = strs[0]
        count = len(strs)
        for i in range(1, count):
            prefix = self.lcp(prefix, strs[i])
            if not prefix:
                break

        return prefix

    def lcp(self, str1, str2):
        length = min(len(str1), len(str2))
        index = 0
        while index < length and str1[index] == str2[index]:
            index += 1
        return str1[:index]


if __name__ == '__main__':
    s = Solution()
    print(s.longestCommonPrefix(["flower", "flow", "flight"]))
