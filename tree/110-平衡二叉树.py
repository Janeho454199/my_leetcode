# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from tree.TreeNode import TreeNode


class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        """
        对于当前遍历到的节点，首先计算左右子树的高度，如果左右子树的高度差是否不超过 1，
        再分别递归地遍历左右子节点，并判断左子树和右子树是否平衡
        :param root:
        :return:
        """
        def height(root: TreeNode) -> int:
            if not root:
                return 0
            return max(height(root.left), height(root.right)) + 1

        if not root:
            return True
        return abs(height(root.left) - height(root.right)) <= 1 and self.isBalanced(root.left) and self.isBalanced(root.right)
