

import java.util.Stack;

public class 力扣206反转链表 {
    public static ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode header = new ListNode(stack.pop().val);
        ListNode node = header;
        while (!stack.isEmpty()) {
            node.next = new ListNode(stack.pop().val);
            node = node.next;
        }
        return header;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5};
        ListNode first = null, last = null, newNode;
        for (int j : input) {
            newNode = new ListNode(j);
            newNode.next = null;
            if (first == null) {
                first = newNode;
                last = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }
        }
        ListNode test = reverseList(first);
    }
}
