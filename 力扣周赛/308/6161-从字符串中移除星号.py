import re


class Solution:
    def removeStars(self, s: str) -> str:
        """
        思路：递归（超时）
        """

        s = re.sub(pattern=r'\w\*', repl='', string=s)

        if re.search(r'\w\*', s):
            s = self.removeStars(s)
        return s

    def removeStars2(self, s: str) -> str:
        """
        思路：栈一次遍历（ac）
        """
        stack = []
        for i in s:
            if i != '*':
                stack.append(i)
            else:
                stack.pop(-1)

        return ''.join(stack)


if __name__ == '__main__':
    s = Solution()
    print(s.removeStars2("leet**cod*e"))