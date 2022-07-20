class MyCalendarTwo(object):

    def __init__(self):
        self.date = []
        self.trouble = []

    def book(self, start, end):
        """
        :type start: int
        :type end: int
        :rtype: bool
        """
        if any(s < end and start < e for s, e in self.trouble):
            return False
        for s, e in self.date:
            if s < end and start < e:
                self.trouble.append((max(s, start), min(e, end)))
        self.date.append((start, end))
        return True


# Your MyCalendarTwo object will be instantiated and called as such:
# obj = MyCalendarTwo()
# param_1 = obj.book(start,end)