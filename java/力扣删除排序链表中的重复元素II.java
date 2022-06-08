

import java.util.HashSet;
import java.util.Set;

public class 力扣删除排序链表中的重复元素II {
    public  ListNode 力扣删除排序链表中的重复元素II(ListNode head) {
        ListNode header = head;
        ListNode result = head;
        Set<Integer> set = new HashSet<Integer>();
        if(head == null){
            return result;
        }
        while(head != null){
            set.add((head.val));
            head = head.next;
        }
        System.out.println(set);
        for(Integer i: set){
            header.val = i;
            header = header.next;
        }
        header.next = null;
        return result;
    }
}