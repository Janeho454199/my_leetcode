package 二叉树;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 力扣113路径总和Ⅱ {
    //定义一个ret装结果
    List<List<Integer>> ret = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return ret;
    }
    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        //offerlast向队尾插入元素
        path.offerLast(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        path.pollLast();
    }
}
