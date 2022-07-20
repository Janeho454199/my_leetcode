"""
有效 二叉搜索树定义如下：
节点的左子树只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from tree.TreeNode import TreeNode
from tree.construct_binary_tree import construct_binary_tree


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # 根据二叉搜索树的性质，如果两个节点都小于当前节点，那他们的父节点就在左子树，反之右子树。
        if root.val > p.val and root.val > q.val:
            return self.lowestCommonAncestor(root.left, p, q)
        elif root.val < p.val and root.val < q.val:
            return self.lowestCommonAncestor(root.right, p, q)
        else:
            return root


if __name__ == '__main__':
    nums = [6, 2, 8, 0, 4, 7, 9, None, None, 3, 5]  # 输入一个序列
    root = construct_binary_tree(nums)  # 构造二叉树
    s = Solution()
    ss = s.lowestCommonAncestor(root, TreeNode(2), TreeNode(4))
    print('done!')
