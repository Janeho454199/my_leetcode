package 二叉树;

import java.util.*;

public class 力扣二叉树的锯齿形遍历 {
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        queue.offer(root);
        int cur = 0;
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
            if(result.size() % 2 != 0){
                Collections.reverse(res);
            }
            result.add(res);
        }
        return result;
    }
}
