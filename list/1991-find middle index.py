"""
思路：计算最大值，然后遍历数组，不停查找能使两边相等的值
"""


class Solution:
    def findMiddleIndex(self, nums):
        pre_sum, total = 0, sum(nums)
        for i in range(len(nums)):
            if total - nums[i] == pre_sum * 2:
                return i
            pre_sum += nums[i]
        return -1


if __name__ == '__main__':
    s = Solution()
    print(s.findMiddleIndex([0]))
