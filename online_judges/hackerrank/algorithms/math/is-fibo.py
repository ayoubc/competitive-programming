import io
from math import sqrt
# import fileinput
# for line in fileinput.input()


class Solution:
    def is_perfect(self, x):
        q = int(sqrt(x))
        return q * q == x

    def solve(self, n):
        return "IsFibo" if self.is_perfect(5 * n * n - 4) or self.is_perfect(5 * n * n + 4) else "IsNotFibo"


out = io.StringIO()
t = int(input())
sol = Solution()
for _ in range(t):
    n = int(input())
    out.write(f'{sol.solve(n)}\n')

print(out.getvalue())
