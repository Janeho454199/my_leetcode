"""
# Definition for a QuadTree node.
class Node(object):
    def __init__(self, val, isLeaf, topLeft, topRight, bottomLeft, bottomRight):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight
"""
class Node(object):
    def __init__(self, val, isLeaf, topLeft, topRight, bottomLeft, bottomRight):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight


class Solution(object):
    def intersect(self, quadTree1: Node, quadTree2: Node):
        """
        :type quadTree1: Node
        :type quadTree2: Node
        :rtype: Node
        """
        # true || x = true
        # false || x = x
        # 如果A为叶子节点，并且A的值等于true, 这时直接返回true, 不用管B, 此时的B是什么已经无所谓了
        if (quadTree1.isLeaf and quadTree1.val) or (quadTree2.isLeaf and not quadTree2.val):
            return quadTree1
        # 若A节点是叶子节点，并且值为0,则新创建的节点和b节点相同。
        if (quadTree2.isLeaf and quadTree2.val) or (quadTree1.isLeaf and not quadTree1.val):
            return quadTree2

        # 递归
        top1 = self.intersect(quadTree1.topLeft, quadTree2.topLeft)
        top2 = self.intersect(quadTree1.topRight, quadTree2.topRight)
        bot1 = self.intersect(quadTree1.bottomLeft, quadTree2.bottomLeft)
        bot2 = self.intersect(quadTree1.bottomRight, quadTree2.bottomRight)

        # 如果都为叶子节点且值相同则合并
        if top1.isLeaf and top2.isLeaf and bot1.isLeaf and bot2.isLeaf and top1.val and top2.val \
            and bot1.val and bot2.val:
            return top1

        return Node(False, False, top1, top2, bot1, bot2)