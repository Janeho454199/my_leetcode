import re


class Solution:
    def decodeString(self, s):
        def multiple_str(match):
            """
            返回 n*m
            :param match:
            :return:
            """
            num = match.group(1)
            string = match.group(2)
            return int(num) * string

        s = re.sub(pattern=r'(\d+)\[(\w+)\]', repl=multiple_str, string=s, flags=re.I)

        if re.search(r'(\d+)\[(\w+)\]', s, flags=re.I):
            s = self.decodeString(s)
        return s


if __name__ == '__main__':
    s = Solution()
    print(s.decodeString('100[leetcode]'))
