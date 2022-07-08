# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import queue
from typing import List
from tree.TreeNode import TreeNode


class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
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
                if cur_node.left:
                    stack.put(cur_node.left)
                if cur_node.right:
                    stack.put(cur_node.right)
            res.append(temp)

        return res


