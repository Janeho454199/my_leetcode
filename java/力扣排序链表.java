

import java.util.*;

public class 力扣排序链表 {
//    public 二叉树.ListNode sortList(二叉树.ListNode head) {
//        if(head == null){
//            return head;
//        }
//        二叉树.ListNode node = head;
//        Queue<Integer> pq = new PriorityQueue<>();
//        while(node != null){
//            pq.add(node.val);
//            node = node.next;
//        }
//        二叉树.ListNode result = new 二叉树.ListNode(pq.poll());
//        二叉树.ListNode answer = result;
//        while (!pq.isEmpty()){
//            二叉树.ListNode temp = new 二叉树.ListNode(pq.poll());
//            result.next = temp;
//            result = result.next;
//        }
//        return answer;
//    }
    public ListNode sortList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode node = head;
        List<Integer> list = new LinkedList<>();
        while(node != null){
            list.add(node.val);
            node = node.next;
        }
        Collections.sort(list);
        ListNode result = new ListNode(list.get(0));
        ListNode answer = result;
        for(int i = 1; i < list.size(); i++){
            ListNode temp = new ListNode(list.get(i));
            result.next = temp;
            result = result.next;
        }
        return answer;
    }
}
