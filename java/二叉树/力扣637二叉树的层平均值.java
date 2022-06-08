package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 力扣637二叉树的层平均值 {
    public List<Double> averageOfLevels(TreeNode root) {
        //队列
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int levelNum = queue.size();
            List<Double> tempList = new ArrayList<>();
            for(int i = 0; i < levelNum; i++){
                //出队
                TreeNode node = queue.poll();
                double tempValue = (double)node.val;
                tempList.add(tempValue);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            int sum = 0;
            for(int i = 0; i < tempList.size(); i++){
                sum += tempList.get(i);
            }
            double avg = tempList.size();
            res.add(sum/avg);
            tempList.clear();
        }
        return res;
    }
}
