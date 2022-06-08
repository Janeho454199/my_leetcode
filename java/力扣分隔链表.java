
public class 力扣分隔链表 {
    public ListNode partition(ListNode head, int x) {
        //定义一个small一个large，遍历原链表
        //假如当前节点的值小于X则放到small链表，否则放到large保持原顺序
        //将small的next对接large的head
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
