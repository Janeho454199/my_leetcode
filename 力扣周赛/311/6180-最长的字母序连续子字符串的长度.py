class Solution:
    def longestContinuousSubstring(self, s: str) -> int:
        """
        思路：双指针
        """
        n = len(s)
        if n == 1:
            return 1

        res = 1

        for i in range(n - 1):
            tmp = 1
            while (ord(s[i + 1]) - 1) == ord(s[i]):
                tmp += 1
                i += 1
                # 边界
                if i == (n - 1):
                    break
            res = max(res, tmp)

        return res
