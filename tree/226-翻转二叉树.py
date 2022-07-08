# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from tree.TreeNode import TreeNode


class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        if not root:
            return None

        queue = [root]
        while queue:
            # 每次都从队列中拿一个节点，并交换这个节点的左右子树
            tmp = queue.pop(0)
            tmp.left, tmp.right = tmp.right, tmp.left
            # 如果当前节点的左子树不为空，则放入队列等待后续处理
            if tmp.left:
                queue.append(tmp.left)
            # 如果当前节点的右子树不为空，则放入队列等待后续处理
            if tmp.right:
                queue.append(tmp.right)
        # 返回处理完的根节点
        return root
