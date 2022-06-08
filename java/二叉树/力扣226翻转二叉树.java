package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class 力扣226翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            TreeNode left = node.left, right = node.right;
            if(left != null){
                queue.offer(left);
            }
            if(right != null){
                queue.offer(right);
            }
        }
        return root;
    }
    public TreeNode invertTree1(TreeNode root) {
        //递归函数的终止条件，节点为空时返回
        if(root==null) {
            return null;
        }
        //下面三句是将当前节点的左右子树交换
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        //递归交换当前节点的 左子树
        invertTree(root.left);
        //递归交换当前节点的 右子树
        invertTree(root.right);
        //函数返回时就表示当前这个节点，以及它的左右子树
        //都已经交换完了
        return root;
    }
}
