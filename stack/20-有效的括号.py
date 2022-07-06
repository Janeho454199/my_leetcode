from .stack import Stack


class Solution:
    def isValid(self, s: str) -> bool:
        stack = Stack()

        for i in s:
            if i == '(':
                stack.push(')')
            elif i == '{':
                stack.push('}')
            elif i == '[':
                stack.push(']')
            elif stack.pop() != i:
                return False
            else:
                stack.pop()

        return True
