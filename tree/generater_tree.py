from typing import Optional
from tree.TreeNode import TreeNode


def generate_tree(vals) -> Optional[TreeNode]:
    if len(vals) == 0:
        return None
    # 定义队列
    que = []
    # 由于无法通过是否为 None 来判断该节点的左儿子是否可以填充，用一个记号判断是否需要填充左节点
    fill_left = True
    for val in vals:
        # 非空值返回节点类，否则返回 None
        node = TreeNode(val) if val is not None else None
        if len(que) == 0:
            # 队列为空的话，用 root 记录根结点，用来返回
            root = node
            que.append(node)
        elif fill_left:
            que[0].left = node
            # 填充过左儿子后，改变记号状态
            fill_left = False
            # 非 None 值才进入队列
            if node:
                que.append(node)
        else:
            que[0].right = node
            if node:
                que.append(node)
            # 填充完右儿子，弹出节点
            que.pop(0)
            fill_left = True
    return root
