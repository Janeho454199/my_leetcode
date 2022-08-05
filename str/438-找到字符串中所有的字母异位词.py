import collections
from typing import List


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        """
        思路：滑动窗口
        :param s:
        :param p:
        :return:
        """
        if len(p) > len(s):
            return []

        p_len = len(p)
        s_len = len(s)

        res = []
        kv = collections.defaultdict(list)
        s_count = [0] * 26
        p_count = [0] * 26

        for i in range(p_len):
            s_count[ord(s[i]) - 97] += 1
            p_count[ord(p[i]) - 97] += 1

        if s_count == p_count:
            res.append(0)

        for j in range(p_len, s_len):
            s_count[ord(s[j - p_len]) - 97] -= 1
            s_count[ord(s[j]) - 97] += 1
            if s_count == p_count:
                res.append(j - p_len + 1)

        return res


if __name__ == '__main__':
    s = Solution()
    s.findAnagrams("baa", "aa")