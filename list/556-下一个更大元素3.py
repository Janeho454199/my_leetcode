class Solution:
    def nextGreaterElement(self, n: int) -> int:
        nums = list(str(n))

        # 找到非逆序点
        # 从后向前遍历
        i = len(nums) - 2
        while i >= 0:
            if nums[i] < nums[i + 1]:
                break
            i -= 1

        # 不存在
        if i < 0:
            return -1

        # 从后往前，找到第一个比nums[i]大的数并交换
        j = len(nums) - 1
        while j >= 0 and nums[i] >= nums[j]:
            j -= 1
        nums[i], nums[j] = nums[j], nums[i]
        # 将i后面的数组翻转
        nums[i + 1:] = nums[i+1:][::-1]
        # 拼接为字符串
        ans = int(''.join(nums))
        #  返回的是32位整数，如果存在满足题意的答案，但不是32位整数，返回-1
        return ans if ans < 2 ** 31 else -1
