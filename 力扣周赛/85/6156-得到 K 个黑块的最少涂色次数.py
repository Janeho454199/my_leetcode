import sys


class Solution:
    def minimumRecolors(self, blocks: str, k: int) -> int:
        if 'B' * k in blocks:
            return 0

        b_count = 0
        w_count = 0
        for i in range(k):
            if blocks[i] == 'B':
                b_count += 1
            else:
                w_count += 1

        res = w_count
        n = len(blocks)

        for i in range(k, n):
            if blocks[i] == 'B':
                b_count += 1
            else:
                w_count += 1

            if blocks[i - k] == 'B':
                b_count -= 1
            else:
                w_count -= 1

            res = min(res, w_count)

        return res


if __name__ == '__main__':
    s = Solution()
    print(s.minimumRecolors("WBBWWBBWBWWBBWWBBWBWWBBWWBBWBWWBBWWBBWBWWBBWWBBWBWBBBBBBWWWWWW",14))