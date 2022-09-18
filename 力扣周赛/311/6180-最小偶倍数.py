class Solution:
    def smallestEvenMultiple(self, n: int) -> int:
        for i in range(n, 0, -1):
            if n % i == 0 and 2 % i == 0:
                return n * 2 // i

        return n * 2