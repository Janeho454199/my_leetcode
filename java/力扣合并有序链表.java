

public class 力扣合并有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = new ListNode(0);
        pre = cur;

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;

            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;

            while (l1 == null && l2 != null) {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;

            }
            while (l2 == null && l1 != null) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;

            }

        }
        return pre.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
