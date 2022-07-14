from stack.stack import Stack


class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        if s == '':
            return True
        stack = Stack()

        for i in s:
            stack.push(i)

        for j in t[::-1]:
            if j == stack.top():
                stack.pop()
            if stack.empty():
                return True

        return stack.empty()
