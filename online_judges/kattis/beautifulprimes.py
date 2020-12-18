import io
import math
from collections import deque
# import fileinput
# for line in fileinput.input()


class Solution:
    def __init__(self):
        self.primes = [2, 11]

    def solve(self, n):
        res = []
        for a in range(n+1):
            if int(a * math.log10(2) + (n - a) * math.log10(11)) == n - 1:
                res = a * [2] + (n - a) * [11]
                break
        return res


out = io.StringIO()
t = int(input())
sol = Solution()
for tc in range(t):
    n = int(input())
    ans = " ".join(map(str, sol.solve(n)))
    out.write(f'{ans}\n')

print(out.getvalue())
