"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""


class Solution(object):
    def preorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        res = []

        def dfs(node):
            if node is None:
                return
            res.append(node.val)
            for ch in node.children:
                dfs(ch)

        dfs(root)

        return res
