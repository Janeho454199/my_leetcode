package 二叉树;

import java.util.*;

public class 二叉树前序遍历 {
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        pos(root);
        return result;
    }
    public void pos(TreeNode node){
        if(node == null){
            return;
        }
        else{
            result.add(node.val);
        }
        pos(node.left);
        pos(node.right);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }
}
