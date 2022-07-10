# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional

from tree.TreeNode import TreeNode


class Solution:

    def __init__(self):
        self.arr = set()

    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        if root is None:
            return False
        if k - root.val in self.arr:
            return True
        self.arr.add(root.val)
        return self.findTarget(root.left, k) or self.findTarget(root.right, k)
