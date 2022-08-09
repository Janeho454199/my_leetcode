# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from typing import Optional

from list.ListNode import ListNode


class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        list_node = []
        while head:
            list_node.append(head)
            head = head.next

        n = len(list_node)

        i, j = 0, len(list_node) - 1
        while i < j:
            list_node[i].next = list_node[j]
            i += 1
            if i == j:
                break
            list_node[j].next = list_node[i]
            j -= 1

        list_node[i].next = None
