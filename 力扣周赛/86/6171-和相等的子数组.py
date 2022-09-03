from typing import List


class Solution:
    def findSubarrays(self, nums: List[int]) -> bool:
        """
        双指针
        """
        n = len(nums)
        if n <= 2:
            return False

        for i in range(n - 2):
            cur_sum = nums[i] + nums[i + 1]
            for j in range(i + 1, n - 1):
                sec_sum = nums[j] + nums[j + 1]
                if cur_sum == sec_sum:
                    return True

        return False


if __name__ == '__main__':
    s = Solution()
    print(s.findSubarrays([1,1,1]))