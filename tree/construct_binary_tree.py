from tree.TreeNode import TreeNode


def construct_binary_tree(nums):
    """根据数组构造二叉树"""
    Treelist = [None for _ in range(len(nums))]
    # 把输入数值数组，先转化为二叉树节点数组
    for i in range(len(nums)):
        if nums[i] != None:
            node = TreeNode(nums[i])
            Treelist[i] = node
        if i == 0: root = node
    # 遍历一遍，根据规则左右孩子赋值就可以了
    # 注： 结束规则是 i * 2 + 2 < len(nums
    i = 0
    while i * 2 + 2 < len(nums):
        if Treelist[i] != None:
            # 线性存储转连式存储关键逻辑
            Treelist[i].left = Treelist[i * 2 + 1]
            Treelist[i].right = Treelist[i * 2 + 2]
        i += 1

    return root  # 返回根节点
