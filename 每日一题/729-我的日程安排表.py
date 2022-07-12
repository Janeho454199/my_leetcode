"""
实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。

当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。

日程可以用一对整数 start 和 end 表示，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，start <= x < end 。

实现 MyCalendar 类：

MyCalendar() 初始化日历对象。
boolean book(int start, int end) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。否则，返回 false并且不要将该日程安排添加到日历中。

输入：
["MyCalendar", "book", "book", "book"]
[[], [10, 20], [15, 25], [20, 30]]
输出：
[null, true, false, true]

解释：
MyCalendar myCalendar = new MyCalendar();
myCalendar.book(10, 20); // return True
myCalendar.book(15, 25); // return False ，这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了。
myCalendar.book(20, 30); // return True ，这个日程安排可以添加到日历中，因为第一个日程安排预订的每个时间都小于 20 ，且不包含时间 20 。
["MyCalendar","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book"]
[[],[20,29],[13,22],[44,50],[1,7],[2,10],[14,20],[19,25],[36,42],[45,50],[47,50],[39,45],[44,50],[16,25],[45,50],[45,50],[12,20],[21,29],[11,20],[12,17],[34,40],[10,18],[38,44],[23,32],[38,44],[15,20],[27,33],[34,42],[44,50],[35,40],[24,31]]
"""


class MyCalendar:
    """
    start <= x < end
    程序逻辑：
    当区间相互独立，则互不影响，并添加到日程中，返回Ture
    当区间有交叉，则不能添加到日程中，返回False
    """
    def __init__(self):
        """
        思路①：暴力loop(超时)
        """
        self.calendar = {}
        """
        改用列表
        """
        self.booked = []

    def book(self, start: int, end: int) -> bool:
        """
        超时
        """
        # temp = {}
        # for i in range(start, end, 1):
        #     if self.calendar.get(i, 0):
        #         return False
        #     else:
        #         temp[i] = 1
        # self.calendar.update(temp)
        """
        每次只判断区间，遍历所有区间
        """
        if any(l < end and start < r for l, r in self.booked):
            return False
        self.booked.append((start, end))
        return True


if __name__ == '__main__':
    ll = [[20,29],[13,22],[44,50],[1,7],[2,10],[14,20],[19,25],[36,42],[45,50],[47,50],[39,45],[44,50],[16,25],[45,50],[45,50],[12,20],[21,29],[11,20],[12,17],[34,40],[10,18],[38,44],[23,32],[38,44],[15,20],[27,33],[34,42],[44,50],[35,40],[24,31]]
    tt = MyCalendar()
    for l in ll:
        print(tt.book(l[0], l[1]))
