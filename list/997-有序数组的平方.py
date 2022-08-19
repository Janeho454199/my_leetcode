class Solution(object):
    def sortedSquares(self, nums):
        """
        从两端开始遍历，找到最大的放到结果数组的末尾
        :param nums:
        :return:
        """
        n = len(nums)
        res = [0] * n
        left = 0
        right = n - 1
        index = n - 1

        while left <= right:
            if nums[left] * nums[left] >= nums[right] * nums[right]:
                res[index] = nums[left] * nums[left]
                left += 1
            elif nums[left] * nums[left] < nums[right] * nums[right]:
                res[index] = nums[right] * nums[right]
                right -= 1
            index -= 1

        return res
