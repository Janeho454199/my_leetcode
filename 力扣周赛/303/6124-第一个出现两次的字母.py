class Solution:
    def repeatedCharacter(self, s: str) -> str:
        hash_map = {}
        for i in range(len(s)):
            if s[i] in hash_map:
                return s[i]
            else:
                hash_map[s[i]] = 1


if __name__ == '__main__':
    s = Solution()
    print(s.repeatedCharacter("nwcn"))
