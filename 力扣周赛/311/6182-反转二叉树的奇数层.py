# Definition for a binary tree node.
import queue
from typing import Optional

from stack.stack import Stack
from tree.generater_tree import generate_tree


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def reverseOddLevels(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        """
        题意：反转奇数层的值
        思路：层序遍历 + 栈和队列重构二叉树
        队列用来做层序顺序遍历，栈用来实现反转
        """
        res = root
        q = queue.Queue()
        stack = Stack()
        q.put(root)
        cur_n = 0

        while q.empty() is not True:
            cur_n += 1
            cur_nums = q.qsize()
            temp = []
            for _ in range(cur_nums):
                cur_node = q.get()
                temp.append(cur_node.val)
                if cur_n % 2 != 0:
                    stack.push(cur_node.left)
                    stack.push(cur_node.right)
                if cur_node.left:
                    q.put(cur_node.left)
                if cur_node.right:
                    q.put(cur_node.right)

            # 奇数层
            if cur_n % 2 == 0:
                for _ in range(cur_nums):
                    rev_node = stack.pop()
                    rev_node.val = temp.pop(0)

        return res


if __name__ == '__main__':
    s = Solution()
    print(s.reverseOddLevels(generate_tree([0,1,2,0,0,0,0,1,1,1,1,2,2,2,2])))

