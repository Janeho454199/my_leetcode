from typing import List


class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        stack = []
        hash_table = {i:-1 for i in nums2}

        for num in nums2:
            # 大于栈顶元素
            while stack and num > stack[-1]:
                hash_table[stack.pop()] = num
            stack.append(num)

        res = [hash_table[key] for key in nums1]

        return res