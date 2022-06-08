

import java.util.LinkedList;
import java.util.List;

public class 力扣旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        // 记录头节点
        ListNode header = head;
        ListNode cur = head;
        List<Integer> list = new LinkedList<>();
        if(head == null){
            return null;
        }
        // 计算长度并存储
        while(cur != null){
            list.add(cur.val);
            cur = cur.next;
        }
        if(k % list.size() == 0 || list.size() == 1){
            return head;
        }
        cur = head;
        // 0,1,2
        if(k < list.size()){
            for(int i = 0; i < list.size(); i++){
                int index = i + Math.abs(k - list.size());
                if(index >= list.size()){
                    index = index - list.size();
                }
                cur.val = list.get(index);
                cur = cur.next;
            }
        }
        if(k > list.size()){
            for(int i = 0; i < list.size(); i++){
                int index = list.size() - k % list.size() + i;
                if(index >= list.size()){
                    index -= list.size();
                }
                cur.val = list.get(index);
                cur = cur.next;
            }
        }
        return header;
    }
}
