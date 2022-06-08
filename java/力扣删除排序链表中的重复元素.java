

public class 力扣删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        if(head == null){
            return head;
        }
        while(temp.next != null && temp != null){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        return head;
    }
}
