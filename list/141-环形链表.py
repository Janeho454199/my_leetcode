from typing import Optional
from list import ListNode


class Solution:
    nums = []

    def hasCycle(self, head: Optional[ListNode]) -> bool:
        """
        思路：记录走过的点
        :param head:
        :return:
        """
        if head is None:
            return False

        while head:
            if head.val in self.nums:
                return True
            self.nums.append(head.val)
            head = head.next

        return False

    def detectCycle2(self, head):
        """
        根据：
        f=2s （快指针每次2步，路程刚好2倍）
        f = s + nb (相遇时，刚好多走了n圈）
        推出：s = nb
        从head结点走到入环点需要走 ： a + nb， 而slow已经走了nb，那么slow再走a步就是入环点了。
        如何知道slow刚好走了a步？ 从head开始，和slow指针一起走，相遇时刚好就是a步
        """
        fast, slow = head, head
        while True:
            if not (fast and fast.next): return
            fast, slow = fast.next.next, slow.next
            if fast == slow: break
        fast = head
        while fast != slow:
            fast, slow = fast.next, slow.next
        return fast
