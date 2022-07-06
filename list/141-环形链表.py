from typing import Optional
from list import ListNode


class Solution:
    nums = []

    def hasCycle(self, head: Optional[ListNode]) -> bool:
        if head is None:
            return False

        while head:
            if head.val in self.nums:
                return True
            self.nums.append(head.val)
            head = head.next

        return False
