import io
from collections import deque
import fileinput
# for line in fileinput.input()


class Solution:
    def solve(self, n):
        if n == 3:
            return 4
        ans = n
        m = n - 3
        i = 1
        while i * i <= m:
            if m % i == 0:
                q = m // i
                if n % i == 3:
                    ans = min(ans, i)
                if n % q == 3:
                    ans = min(ans, q)
            i += 1
        if ans == n:
            return 'No such base'
        return ans


out = io.StringIO()
# t = int(input())
sol = Solution()
# for tc in range(t):
for line in fileinput.input():
    n = int(line)
    if n == 0:
        break
    ans = sol.solve(n)
    out.write(f'{ans}\n')
print(out.getvalue())
