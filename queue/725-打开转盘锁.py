"""
思路：双向BFS

BFS通用基本框架
queue = [起始点]    # 队列实现BFS
visited = set()    # 记录访问过的元素点，避免“回头”访问，陷入循环
visited.add(起始点)
step = 0
while queue:
    # 将所有节点同时向前扩散一步
    for _ in range(len(queue)):
        cur = queue.pop(0)
        if 找到目标:
            return 结果
        # 将cur的【所有相邻且没被访问过的节点】加入队列
        for near in cur的邻近节点：
            if near not in visited:
                queue.append(near)
                visited.add(near)
    step += 1    # 记录路径长度
"""
import queue


class Solution:
    def openLock(self, deadends, target):
        q = queue.Queue()
        q.put('0000')
        visited = set()
        visited.add('0000')
        deadset = set(deadends)
        step = 0

        while q.qsize():
            for _ in range(q.qsize()):
                cur = q.get()
                if cur in deadset:
                    continue
                if cur == target:
                    return step
                for i in range(4):
                    up = self.up(cur, i)
                    if up not in visited:
                        q.put(up)
                        visited.add(up)
                    down = self.down(cur, i)
                    if down not in visited:
                        q.put(down)
                        visited.add(down)
            step += 1
        return -1

    def up(self, c, i):
        c = list(c)
        if c[i] == '9':
            c[i] = '0'
        else:
            c[i] = str(int(c[i]) + 1)
        return ''.join(c)

    def down(self, c, i):
        c = list(c)
        if c[i] == '0':
            c[i] = '9'
        else:
            c[i] = str(int(c[i]) - 1)
        return ''.join(c)


if __name__ == '__main__':
    s = Solution()
    print(s.openLock(["0201", "0101", "0102", "1212", "2002"], "0202"))
