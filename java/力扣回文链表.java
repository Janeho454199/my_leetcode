

import java.util.Stack;

public class 力扣回文链表 {
    public boolean isPalindrome(ListNode head) {
        //用快慢指针定位中点，并用栈存储前半段链表，然后后半段与栈对比
        if (head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack();
        stack.push(slow.val);
        //定位中点
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            stack.push(slow.val);
        }
        //移动到下半部分的开始
        if(fast.next != null){
            slow = slow.next;
        }
        //一一对比
        while(!stack.isEmpty()){
            if(slow.val != stack.pop()){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
