import collections
from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        """
        思路：计数
        :param strs:
        :return:
        """
        if strs == [""]:
            return [[""]]

        kv = collections.defaultdict(list)

        for s in strs:
            flag = [0] * 26
            s_list = list(str(s))
            for i in s_list:
                if ord(i) != 0:
                    flag[ord(i) - 97] += 1

            kv[''.join(str(flag))].append(s)

        res = [s_list for s_list in kv.values()]

        return res


if __name__ == '__main__':
    s = Solution()
    s.groupAnagrams(["ac","d"])