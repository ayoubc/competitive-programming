# from io import StringIO
from math import ceil, sqrt


class Solution:

    def solve(self, r, x, y):
        d = x ** 2 + y ** 2
        if r * r > d:
            return 2

        return ceil(sqrt(d) / r)


sol = Solution()
r, x, y = [int(_) for _ in input().split()]
print(sol.solve(r, x, y))