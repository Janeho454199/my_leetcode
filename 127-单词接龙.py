"""
思路：双向BFS，两边同时进行BFS
"""
import queue


class Solution:
    def ladderLength(self, beginWord, endWord, wordList):
        """
        单向BFS
        :param beginWord:
        :param endWord:
        :param wordList:
        :return:
        """
        # 初始化
        if endWord not in wordList:
            return 0
        q = queue.Queue()
        q.put((beginWord, 1))
        # 记录
        visited = set()
        visited.add(beginWord)
        m = len(beginWord)

        while q.qsize():
            cur, step = q.get()
            if cur == endWord:
                return step

            # BFS寻找所有可能的路径
            for i in range(m):
                for j in range(26):
                    tmp = cur[:i] + chr(97+j) + cur[i+1:]
                    if tmp not in visited and tmp in wordList:
                        q.put((tmp, step + 1))
                        visited.add(tmp)

        return 0

    def ladderLength2(self, beginWord, endWord, wordList):
        """
        双向BFS
        :param beginWord:
        :param endWord:
        :param wordList:
        :return:
        """
        if endWord not in wordList:
            return 0
        m = len(beginWord)
        lvisited = set()
        rvisited = set()
        lqueue = queue.Queue()
        rqueue = queue.Queue()

        lqueue.put(beginWord)
        rqueue.put(endWord)

        lvisited.add(beginWord)
        rvisited.add(endWord)
        step = 0

        while lqueue.qsize() and rqueue.qsize():
            if lqueue.qsize() > rqueue.qsize():
                lqueue, rqueue = rqueue, lqueue
                lvisited, rvisited = rvisited, lvisited
            step += 1
            for k in range(lqueue.qsize()):
                cur = lqueue.get()
                if cur in rvisited:
                    return step

                for i in range(m):
                    for j in range(26):
                        tmp = cur[:i] + chr(97 + j) + cur[i + 1:]
                        if tmp not in lvisited and tmp in wordList:
                            lqueue.put(tmp)
                            lvisited.add(tmp)

        return 0


if __name__ == '__main__':
    s = Solution()
    print(s.ladderLength2("hot","dog",["hot","dog"]))
