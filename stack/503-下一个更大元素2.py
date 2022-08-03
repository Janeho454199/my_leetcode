from typing import List


class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        nums = nums * 2
        print(nums)


if __name__ == '__main__':
    s = Solution()
    s.nextGreaterElements([1,2,3,4])