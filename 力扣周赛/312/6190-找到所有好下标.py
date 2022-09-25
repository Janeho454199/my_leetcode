"""
先倒着遍历，得到从每个位置向后的最长连续非降序列的长度
然后正着遍历，得到每个位置向前的最长连续非增序列的长度，同时统计答案。
"""
from typing import List


class Solution:
    def goodIndices(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        ans = []
        dec = [1] * n
        for i in range(n - 2, 1, -1):
            if nums[i] <= nums[i + 1]:
                dec[i] = dec[i + 1] + 1  # 递推
        inc = 1
        for i in range(1, n - 1):
            if inc >= k and dec[i + 1] >= k:
                ans.append(i)
            if nums[i - 1] >= nums[i]:
                inc += 1  # 递推
            else:
                inc = 1
        return ans
