"""
给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。

注意：如果对空文本输入退格字符，文本继续为空。
"""


class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        s_stack = []
        t_stack = []

        for i in s:
            if i == '#' and s_stack:
                s_stack.pop()
            elif i == '#' and not s_stack:
                continue
            else:
                s_stack.append(i)

        for i in t:
            if i == '#' and t_stack:
                t_stack.pop()
            elif i == '#' and not t_stack:
                continue
            else:
                t_stack.append(i)

        if s_stack == t_stack:
            return True
        else:
            return False
        