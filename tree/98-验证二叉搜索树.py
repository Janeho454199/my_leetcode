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
