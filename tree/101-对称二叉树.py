# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from idlelib.tree import TreeNode
from typing import Optional


class Solution:
    """
    对称二叉树，左右子树同位置值相等
    """
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True

        queue = [root.left, root.rifht]

        while queue:
            left = queue.pop()
            right = queue.pop()

            # 若当前出队的两个节点均为空
            if not (right or left):
                continue
            # 若当前出队的两个节点只有一个为空或者二者均不为空但是节点值不相等
            if not (right and left):
                return False
            if right.val != left.val:
                return False

            queue.append(left.left)
            queue.append(right.right)
            queue.append(left.right)
            queue.append(right.left)

        return True
