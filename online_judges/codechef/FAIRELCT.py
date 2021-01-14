import io
from sys import stdin


class Solution:
    def solve(self, n, m, a, b):
        a.sort()
        b.sort()
        ans = 0
        s_a = sum(a)
        s_b = sum(b)
        i = 0
        j = m-1
        found = False
        while True:
            if s_a > s_b:
                found = True
                break
            if i >= n or j < 0:
                break
            if a[i] < b[j]:
                s_a += b[j] - a[i]
                s_b += a[i] - b[j]
                i += 1
                j -= 1
                ans += 1
            else:
                break
        ans = ans if found else -1
        return ans


out = io.StringIO()
sol = Solution()
t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    a = [int(x) for x in input().split()]
    b = [int(x) for x in input().split()]
    out.write(f'{sol.solve(n, m, a, b)}\n')

print(out.getvalue())
