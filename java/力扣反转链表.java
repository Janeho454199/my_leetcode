

import java.util.Stack;

public class 力扣反转链表 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        Stack<Integer> result = new Stack<Integer>();
        ListNode node = head;
        while(node != null){
            result.push(node.val);
            node = node.next;
        }
        ListNode answer = new ListNode(result.pop());
        ListNode cur = answer;
        while(!result.isEmpty()){
            cur.next = new ListNode(result.pop());
            cur = cur.next;
        }
        return answer;
    }
}
