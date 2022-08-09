from typing import Optional


class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random


class Solution:
    def copyRandomList(self, head: Optional[Node]) -> Optional[Node]:
        if not head:
            return head
        # 复制每个节点，并将原链表和复制链表连在一起。
        p = head
        while p:
            q = Node(p.val, p.next, None)
            p.next = q
            p = p.next.next

        p = head
        copyHead = head.next
        # p->next->random = p->random->next，这样我们就完成了对原链表 random 指针的复刻
        while p:
            if p.random:
                p.next.random = p.random.next
            p = p.next.next

        # 拆分两个链表，并复原原链表
        cur = head
        cur_ = copyHead
        while cur and cur_:
            cur.next = cur_.next
            cur = cur.next
            if cur:
                cur_.next = cur.next
            cur_ = cur_.next
        return copyHead
