package 二叉树;

public class 力扣701二叉搜索树中的插入操作 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode cNode = root;
        while(cNode != null){
            if(cNode.val > val){
                if(cNode.left == null){
                    cNode.left = new TreeNode(val);
                    break;
                }else{
                    cNode = cNode.left;
                }
            }
            if(cNode.val < val){
                if(cNode.right == null){
                    cNode.right = new TreeNode(val);
                    break;
                }else{
                    cNode = cNode.right;
                }
            }
        }
        return root;
    }
}
