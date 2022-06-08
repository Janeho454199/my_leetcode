package 二叉树;

import java.util.Deque;
import java.util.LinkedList;

public class 力扣112路径总和 {
    Deque<Integer> path = new LinkedList<>();
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }
    public boolean dfs(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if(root.left == null && root.right == null) {
            return sum == 0;
        }
        return dfs(root.left, sum) || dfs(root.right, sum);
    }
}
