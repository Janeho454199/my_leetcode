from typing import List


class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        """
        这题看着有一点点唬人，毕竟牵涉到了位运算。但是位与有一个非常简单的性质：位与后数值单调不增。因此子数组位与的最大值应当为数组本身的最大值。
        而一个子数组要满足其位与和为数组本身的最大值，则其应当满足每一项均为数组本身的最大值。
        因此本题求的即为最长的均为数组最大值的子数组长度。
        """
        tmp = max(nums)
        cnt, ans = 0, 0
        for num in nums:
            if num == tmp:
                cnt += 1
                if cnt > ans: ans = cnt
            else:
                cnt = 0
        return ans


if __name__ == '__main__':
    s = Solution()
    s.longestSubarray([96317,96317,96317,96317,96317,96317,96317,96317,96317,279979])
    s.longestSubarray([323376,323376,323376,323376,323376,323376,323376,75940,75940])
