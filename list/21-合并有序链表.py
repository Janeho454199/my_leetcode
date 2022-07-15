from typing import Optional

from list import ListNode


class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if list1 is None:
            return list2
        if list2 is None:
            return list1

        head = ListNode.ListNode(0)
        res = ListNode.ListNode(0)
        res.next = head

        while list1 and list2:
            if list1.val > list2.val:
                head.next = list2
                head = head.next
                list2 = list2.next
            else:
                head.next = list1
                head = head.next
                list1 = list1.next

            while list1 and list2 is None:
                head.next = list1
                list1 = list1.next
                head = head.next

            while list2 and list1 is None:
                head.next = list2
                list2 = list2.next
                head = head.next

        return res.next


    def mergeTwoLists2(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if list1 is None:
            return list2
        elif list2 is None:
            return list1
        elif list1.val < list2.val:
            list1.next = self.mergeTwoLists(list1.next, list2)
            return list1
        else:
            list2.next = self.mergeTwoLists(list1, list2.next)
            return list2
