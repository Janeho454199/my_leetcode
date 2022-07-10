class SmallestInfiniteSet:

    def __init__(self):
        self.popped = set()

    def popSmallest(self) -> int:
        i = 1
        while i in self.popped:
            i += 1
        self.popped.add(i)
        return i

    def addBack(self, num: int) -> None:
        if num in self.popped:
            self.popped.remove(num)
            