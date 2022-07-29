# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from list.ListNode import ListNode
from tree.TreeNode import TreeNode


class Solution:
    def dfs(self, hd, rt):
        if not hd:
            return True
        if not rt:
            return False
        if rt.val != hd.val:
            return False
        return self.dfs(hd.next, rt.left) or self.dfs(hd.next, rt.right)

    def isSubPath(self, head: ListNode, root: TreeNode) -> bool:
        """
        思路：BFS+DFS
        :param head:
        :param root:
        :return:
        """
        if not root:
            return False

        return self.dfs(head, root) or self.isSubPath(head, root.left) or self.isSubPath(head, root.right)
