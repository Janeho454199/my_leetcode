from typing import List


class Solution:
    def answerQueries(self, nums: List[int], queries: List[int]) -> List[int]:

        def check(ceil):
            # 这可以算是一种双指针模板了
            res = 0  # 符合条件的最长子序列长度
            j = 0  # 右指针
            pre = 0  # 前序和
            for i in range(n):
                # 注意右指针始终保持不落后于左指针
                if j < i:
                    j = i
                    pre = 0
                # 移动指针
                while j < n and pre + nums[j] <= ceil:
                    pre += nums[j]
                    j += 1
                # 计算长度
                if j - i > res:
                    res = j - i
                # 减去前缀
                pre -= nums[i]
            return res

        n = len(nums)
        # 排序后挨个查询长度
        nums.sort()
        ans = []
        for target in queries:
            ans.append(check(target))
        return ans
