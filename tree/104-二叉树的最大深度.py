# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional

from tree.TreeNode import TreeNode


class Solution:
    res = 0
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0

        def dfs(tree_node, level):
            if tree_node is None:
                return
            self.res = max(level, self.res)
            dfs(tree_node.left, level + 1)
            dfs(tree_node.right, level + 1)

        dfs(root, 1)

        return self.res
