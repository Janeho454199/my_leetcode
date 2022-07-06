from list.ListNode import ListNode
from stack.stack import Stack


class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head

        stack = Stack()

        while head:
            stack.push(head.val)
            head = head.next
        cur = ListNode(0)
        res = cur
        while stack.isEmpty() is False:
            temp = ListNode(stack.pop())
            cur.next = temp
            cur = cur.next

        return res.next

