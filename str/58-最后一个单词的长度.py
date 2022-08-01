class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        arr = s.strip().split(' ')
        return len(arr[-1])


if __name__ == '__main__':
    s = Solution()
    s.lengthOfLastWord("   fly me   to   the moon  ")