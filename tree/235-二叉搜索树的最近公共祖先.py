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
