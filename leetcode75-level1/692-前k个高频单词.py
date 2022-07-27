import collections
from typing import List


class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        # 利用collections.Counter统计词频
        hash = collections.Counter(words)
        # 按词频倒叙，字母序正序
        res = sorted(hash, key=lambda word:(-hash[word], word))
        return res[:k]


if __name__ == '__main__':
    s = Solution()
    s.topKFrequent(words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2)