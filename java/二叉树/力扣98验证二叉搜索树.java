package 二叉树;

public class 力扣98验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        return check(root, null, null);
    }

    public boolean check(TreeNode root, TreeNode min, TreeNode max) {
        // 空树认为是BST
        if (root == null) { return true; }
        // 一次只检查一个节点，看这个节点是否破坏了BST特性
        if (min != null && root.val <= min.val) { return false; }
        if (max != null && root.val >= max.val) { return false; }
        // 对于左子树的所有节点值来说，最小值为min，最大值为root
        // 对于右子树的所有节点值来说，最小值为root，最大值为max
        return check(root.left, min, root) && check(root.right, root, max);
    }
}
