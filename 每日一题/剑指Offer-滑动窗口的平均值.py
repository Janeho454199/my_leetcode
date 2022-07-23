class MovingAverage:

    def __init__(self, size: int):
        """
        Initialize your data structure here.
        """
        self.size = size
        self.arr = []

    def next(self, val: int) -> float:
        if self.arr == []:
            self.arr.append(val)
            return sum(self.arr)
        else:
            if len(self.arr) == self.size:
                self.arr.pop(0)
                self.arr.append(val)
                return sum(self.arr)/self.size
            else:
                self.arr.append(val)
                return sum(self.arr)/len(self.arr)


if __name__ == '__main__':
    s = MovingAverage(3)
    for i in [[1], [10], [3], [5]]:
        s.next(i[0])