
public class 力扣328奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
        //思路：遍历整个链表，遍历的过程中，将奇数位置的节点连接起来
        //同时也将偶数位置的节点连接起来，最后将奇位置的尾节点连接偶数位置
        if(head == null || head.next == null){
            return head;
        }
        //记录奇位置头节点
        ListNode a = head;
        //记录偶位置头节点
        ListNode b = head.next;
        //踏板节点
        ListNode e = b;
        while(a.next != null && e.next != null){
            //奇数节点的next每次都读取偶数节点的next（偶数节点的next也就是奇数节点）
            a.next = e.next;
            //然后将自己指向自己的下一个奇数节点
            a = a.next;
            //偶数同理
            e.next = a.next;
            e = e.next;
        }
        //将排好的奇位置节点与偶节点相连
        a.next = b;
        return head;
    }
}
