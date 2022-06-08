package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
    private int index;
    private List<Integer> result;
    public BSTIterator(TreeNode root) {
        this.index = 0;
        result = new ArrayList<>();
        inorderTraversal(root);
    }

    public int next() {
        if(index < this.result.size()){
            return this.result.get(this.index++);
        }else{
            return 0;
        }
    }

    public boolean hasNext() {
        if(index < this.result.size()){
            return true;
        }else{
            return false;
        }
    }

    public void inorderTraversal(TreeNode root){
        TreeNode temp = root;
        if(temp == null) {
            return;
        }
        inorderTraversal(temp.left);
        this.result.add(temp.val);
        inorderTraversal(temp.right);
    }

}
