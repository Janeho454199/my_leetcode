from list.ListNode import ListNode


class Solution:
    def removeElements(self, head: ListNode, val: int):
        if head is None:
            return None
        # 往前添加一个空表头
        pre = ListNode(0)
        pre.next = head
        res = pre

        while head.next:
            if head.next.val == val:
                head.next = head.next.next
            else:
                head = head.next

        return res.next

