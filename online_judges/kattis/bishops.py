import io
from sys import stdin


class Solution:

    def __init__(self):
        pass

    def solve(self, n):
        if n <= 1:
            return n
        return 2 * (n - 1)


out = io.StringIO()
sol = Solution()
# t = int(input())
for line in stdin:
    n = int(line)
    print(sol.solve(n))
    # out.write(str(sol.solve(n)) + '\n')
# print(out.getvalue())
