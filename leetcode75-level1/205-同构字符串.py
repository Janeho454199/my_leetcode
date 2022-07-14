class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        hash1 = {}
        hash2 = {}

        for i in range(len(s)):
            if s[i] in hash1 and hash1[s[i]] != t[i]:
                return False
            if t[i] in hash2 and hash2[t[i]] != s[i]:
                return False

            hash1[s[i]] = t[i]
            hash2[t[i]] = s[i]

        return True


if __name__ == '__main__':
    s = Solution()
    s.isIsomorphic("egg",
"add")