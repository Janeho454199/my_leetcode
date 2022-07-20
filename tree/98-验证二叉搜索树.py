"""
有效 二叉搜索树定义如下：
节点的左子树只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
"""
from tree.TreeNode import TreeNode


class Solution:
    # 中序遍历
    def inOrder(self, root: TreeNode, res):
        if root is None:
            return
        self.inOrder(root.left, res)
        res.append(root.val)
        self.inOrder(root.right, res)

    def isValidBST(self, root: TreeNode) -> bool:
        res = []
        self.inOrder(root, res)
        # 判断 res 是否有序
        for i in range(1, len(res)):
            if res[i] <= res[i - 1]:
                return False
        return True
