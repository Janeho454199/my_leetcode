from typing import List


class Solution:
    def arithmeticTriplets(self, nums: List[int], diff: int) -> int:
        """
        loop就完事
        """
        left = 0
        n = len(nums)
        res = 0

        while left < n - 2:
            right = left + 1
            while right < n - 1:
                if nums[right] - nums[left] == diff:
                    index = right + 1
                    for j in range(index, n):
                        if nums[j] - nums[right] == diff:
                            res += 1
                            break
                if nums[right] - nums[left] < diff:
                    right += 1
                else:
                    break

            left += 1

        return res

    def arithmeticTriplets2(self, nums: List[int], diff: int) -> int:
        """
        哈希
        """
        n = len(nums)
        res = 0
        set_list = set()
        for num in nums:
            set_list.add(num)

        for i in range(n - 1):
            for j in range(i + 1, n):
                if nums[j] - nums[i] == diff and (nums[j] + diff) in set_list:
                    res += 1
                    break

        return res


if __name__ == '__main__':
    s = Solution()
    print(s.arithmeticTriplets2(nums = [4,5,6,7,8,9], diff = 2))
