import io
from sys import stdin


class Solution:
    def solve(self, N, K, D, A):
        tot = sum(A)
        ans = min(tot // K, D)
        return ans


out = io.StringIO()
sol = Solution()
t = int(input())
for _ in range(t):
    N, K, D = [int(x) for x in input().split()]
    A = [int(x) for x in input().split()]
    out.write(f'{sol.solve(N, K, D, A)}\n')

print(out.getvalue())
