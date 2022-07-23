# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from list.ListNode import ListNode


class Solution:
    def middleNode(self, head: ListNode) -> ListNode:
        # 快慢指针
        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        return slow