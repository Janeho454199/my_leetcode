class MyQueue:

    def __init__(self):
        self.stack = []
        self.stack_rev = []

    def push(self, x: int) -> None:
        self.stack.append(x)

    def pop(self) -> int:
        while self.stack:
            self.stack_rev.append(self.stack.pop())
        result = self.stack_rev.pop()
        while self.stack_rev:
            self.stack.append(self.stack_rev.pop())
        return result

    def peek(self) -> int:
        while self.stack:
            self.stack_rev.append(self.stack.pop())
        result = self.stack_rev[-1]
        while self.stack_rev:
            self.stack.append(self.stack_rev.pop())
        return result

    def empty(self) -> bool:
        return len(self.stack) == 0
