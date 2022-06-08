package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class 力扣完全二叉树的节点个数 {
    int count = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    public int countNodes(TreeNode root) {
        if(root == null) {
            return count;
        }
        queue.offer(root);
        count++;
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            for(int i = 0; i < levelNum; i++){
                TreeNode node = queue.poll();
                int temp = node.val;
                if(node.left != null){
                    queue.offer(node.left);
                    count++;
                }
                if(node.right != null){
                    queue.offer(node.right);
                    count++;
                }
            }
        }
        return count;
    }
}
