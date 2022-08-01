from typing import List


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        """
        单调栈
        """
        answer = [0] * len(temperatures)
        stack = [0]
        for i in range(1, len(temperatures)):
            # 情况一和情况二
            # 当当前温度小于等于栈顶
            if temperatures[i] <= temperatures[stack[-1]]:
                stack.append(i)
            # 情况三
            # 当当前温度大于栈顶，栈顶元素出栈直到栈为空或者栈顶元素大于当前温度
            else:
                while stack and temperatures[i] > temperatures[stack[-1]]:
                    answer[stack[-1]] = i - stack[-1]
                    stack.pop()
                stack.append(i)

        return answer
