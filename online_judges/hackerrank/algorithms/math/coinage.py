import io
from sys import stdin


class Solution:
    def solve(self, n, A, B, C, D):
        ans = 0
        for d in range(D+1):
            for c in range(C+1):
                r = n - d * 10 - c * 5
                if r >= 0:
                    R = min(r, 2 * B)
                    L = r - min(r, A)
                    ans += max(0, R // 2 - max(0, (L - 1) // 2))
                    if L == 0:
                        ans += 1
        return ans


out = io.StringIO()
sol = Solution()
t = int(input())
for _ in range(t):
    n = int(input())
    A, B, C, D = [int(x) for x in input().split()]
    out.write(f'{sol.solve(n, A, B, C, D)}\n')

print(out.getvalue())
