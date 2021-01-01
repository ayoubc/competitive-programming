import io
from collections import defaultdict
# import fileinput
# for line in fileinput.input()


class Solution:

    def solve(self, n):
        if n <= 4:
            return n - 3

        res = 1
        for i in range(n, n-4, -1):
            res *= i
        return res // 24


# out = io.StringIO()
n = int(input())
sol = Solution()
print(sol.solve(n))
