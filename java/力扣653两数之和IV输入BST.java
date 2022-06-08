

import java.util.HashMap;

public class 力扣653两数之和IV输入BST {
    HashMap<Integer, Integer> map = new HashMap<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        return dfs(root, k);
    }
    public boolean dfs(TreeNode node, int k) {
        if(node == null)
            return false;
        if(map.containsKey(node.val)) {
            return true;
        }
        map.put(k - node.val, node.val);
        return dfs(node.left, k) || dfs(node.right, k);
    }
}
