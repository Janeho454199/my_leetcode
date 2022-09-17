class Solution:
    def maxLengthBetweenEqualCharacters(self, s: str) -> int:
        map_index = {}
        res = -1
        for index in range(len(s)):
            if s[index] in map_index.keys():
                res = max(index - map_index[s[index]], res)
                # map_index[s[index]] = index
            else:
                map_index[s[index]] = index

        return res - 1


if __name__ == '__main__':
    s = Solution()
    s.maxLengthBetweenEqualCharacters("mgntdygtxrvxjnwksqhxuxtrv")
