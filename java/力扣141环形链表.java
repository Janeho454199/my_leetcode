

import java.util.LinkedList;
import java.util.List;

public class 力扣141环形链表 {
    public boolean hasCycle(ListNode head) {
        // 哈希
        if(head == null){
            return false;
        }
        ListNode node = head;
        List<ListNode> list = new LinkedList<>();
        list.add(node);
        while(node.next != null){
            node = node.next;
            if(list.contains(node)){
                return true;
            }
            list.add(node);
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        // 快慢指针
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

