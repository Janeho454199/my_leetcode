"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
import queue


class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Node
        :rtype: List[List[int]]
        """
        if root is None:
            return []

        res = []
        stack = queue.Queue()
        stack.put(root)

        while stack.empty() is not True:
            cur_nums = stack.qsize()
            temp = []
            for i in range(cur_nums):
                cur_node = stack.get()
                temp.append(cur_node.val)
                for node in cur_node.children:
                    stack.put(node)
            res.append(temp)

        return res
