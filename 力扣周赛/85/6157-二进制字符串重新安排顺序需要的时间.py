import re


class Solution:
    res = 0

    def secondsToRemoveOccurrences(self, s: str) -> int:

        def replace(match):
            return '10'

        if re.search(r'(01)', s):
            self.res += 1
            s = re.sub(pattern=r'(01)', repl=replace, string=s)
            self.secondsToRemoveOccurrences(s)
        return self.res


if __name__ == '__main__':
    s = Solution()
    print(s.secondsToRemoveOccurrences(s="11100011010101101010110101011010101101010110101"))
