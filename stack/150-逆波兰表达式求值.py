from typing import List


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []

        for i in tokens:
            if i.isdigit() or i.split('-')[-1].isdigit():
                stack.append(int(i))
            else:
                x = stack.pop()
                y = stack.pop()
                if i == '+':
                    tmp = x + y
                elif i == '-':
                    tmp = y - x
                elif i == '*':
                    tmp = x * y
                else:
                    tmp = int(y / x)
                stack.append(tmp)

        return stack[-1]


if __name__ == '__main__':
    s = Solution()
    s.evalRPN(["2","-1","+","3","*"])
