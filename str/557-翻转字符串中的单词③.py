from typing import List


class Solution:
    def reverseWords(self, s: str) -> str:
        res = []
        str_list = s.split(' ')
        for i in str_list:
            res.append(''.join(self.reverseString(list(i))))

        return ' '.join(res)

    def reverseString(self, s: List[str]):
        """
        Do not return anything, modify s in-place instead.
        """
        left = 0
        right = len(s) - 1

        while left < right:
            s[left], s[right] = s[right], s[left]
            left += 1
            right -= 1
        return s


if __name__ == '__main__':
    s = Solution()
    s.reverseWords("Let's take LeetCode contest")
