package 二叉树;

public class 力扣129求根到叶子节点数字之和 {
    int sum = 0;
    public int sumNumbers(TreeNode root){
        if(root == null){
            return 0;
        }
        int temp = 0;
        dfs(root, temp);
        return sum;
    }
    void dfs(TreeNode root,int temp){
        if(root == null){
            return;
        }
        temp = temp * 10 + root.val;
        dfs(root.left, temp);
        dfs(root.right, temp);
        if(root.left == null && root.right == null){
            sum += temp;
        }
    }
}
