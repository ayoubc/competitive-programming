import io
from sys import stdin


class Solution:
    def __init__(self, limit):
        self.mod = 1000000000
        self.n_c_k = self.pre_n_c_k(limit, self.mod)

    @staticmethod
    def pre_n_c_k(max_n, mod=None):
        c = [[0 for i in range(max_n + 1)] for j in range(max_n + 1)]
        c[0][0] = 1
        for n in range(1, max_n + 1):
            c[n][0], c[n][n] = 1, 1
            for k in range(1, n):
                c[n][k] = c[n - 1][k - 1] + c[n - 1][k]
                if mod is not None:
                    c[n][k] %= mod
        return c

    def solve(self, n):
        ans = [self.n_c_k[n][i] for i in range(n+1)]
        return " ".join(map(str, ans))


out = io.StringIO()
sol = Solution(1000)
t = int(input())
for _ in range(t):
    n = int(input())
    out.write(f'{sol.solve(n)}\n')

print(out.getvalue())
