package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最大深度 {
    int maxlevel = 0;
    public int maxDepth(TreeNode root) {
        if(root == null){
            return maxlevel;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            maxlevel++;
            int csize = queue.size();
            for(int i = 0; i < csize; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return maxlevel;
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
