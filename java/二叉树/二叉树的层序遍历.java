package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层序遍历 {
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> res = new ArrayList<>();
            int levelNum = queue.size();
            for(int i = 0; i < levelNum; i++){
                TreeNode node = queue.poll();
                int temp = node.val;
                res.add(temp);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            result.add(res);
        }
        return result;
    }
}
