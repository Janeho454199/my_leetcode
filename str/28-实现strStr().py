class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n = len(haystack)
        m = len(needle)
        if haystack == needle:
            return 0
        for i in range(n - m + 1):
            index = i
            needle_index = 0
            while needle_index < m and haystack[index] == needle[needle_index]:
                index += 1
                needle_index += 1
            if needle_index == m:
                return i
        return -1
