from list.ListNode import ListNode


class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if head is None:
            return head

        res = ListNode(0)
        res.next = head

        while head.next:
            if head.val == head.next.val:
                head.next = head.next.next
            else:
                head = head.next

        return res.next