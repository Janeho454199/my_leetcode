
public class 力扣203移除链表元素 {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if(head==null)
            return null;
        head.next=removeElements(head.next,val);
        if(head.val==val){
            return head.next;
        }else{
            return head;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{7,7,7,7};
        int a = 7;
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
        ListNode result = removeElements(first, a);
    }
}
