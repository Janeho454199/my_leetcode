

import java.util.Deque;
import java.util.LinkedList;

public class 力扣删除链表倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        //计算链表长度
        int length = getLength(head);
        ListNode cur = dummy;
        //找到倒数第N个节点
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        //删除
        cur.next = cur.next.next;
        //重新指向整个链表并返回
        ListNode ans = dummy.next;
        return ans;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        // 双指针，先扫描n个节点，两个指针再进行同步扫描，当第一个指针扫描到末尾的时候
        // 第二个指针即要删除的节点
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        // 栈
        // 将所有节点入栈，再出栈n个节点
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
