from typing import List


class NumArray:
    """
    前缀和
    sum(nums[i] ~ nums[j]) = pre_sum[j + 1] - pre_sum[i]
    """
    def __init__(self, nums: List[int]):
        self.pre_sum = [nums[0]]
        # 前缀和数组右移一位
        for i in range(1, len(nums) + 1):
            self.pre_sum.append(self.pre_sum[i - 1] + nums[i - 1])

    def sumRange(self, left: int, right: int) -> int:
        return self.pre_sum[right + 1] - self.pre_sum[left]


if __name__ == '__main__':
    s = NumArray([-2,0,3,-5,2,-1])
    print(s.sumRange(0, 2))
