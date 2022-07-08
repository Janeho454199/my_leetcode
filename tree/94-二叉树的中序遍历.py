# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional, List

from tree.TreeNode import TreeNode


class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []

        res = []

        def dfs(tree_node):
            if tree_node is None:
                return
            dfs(tree_node.left)
            res.append(tree_node.val)
            dfs(tree_node.right)

        dfs(root)

        return res