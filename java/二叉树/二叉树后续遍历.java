package 二叉树;

import java.util.*;

public class 二叉树后续遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur.right == null || cur.right == pre){
                ret.add(cur.val);
                pre = cur;
                cur = null;
            }else{
                stack.add(cur);
                cur = cur.right;
            }
        }
        return ret;
    }
}
