import io
from sys import stdin
from math import log2


class Solution:

    def solve(self, y):
        p = (y - 1960) // 10 + 2
        limit = (1 << p)
        n = 3
        fact = log2(6)
        while fact < limit:
            n += 1
            fact += log2(n)
        return n-1


out = io.StringIO()
sol = Solution()

for line in stdin:
    y = int(line)
    if y == 0:
        break
    out.write(f'{sol.solve(y)}\n')

print(out.getvalue())
