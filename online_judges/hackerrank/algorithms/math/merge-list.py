import io


class Solution:
    def __init__(self):
        self.mod = 10 ** 9 + 7
        self.n_c_k = self.pre_n_c_k(200, self.mod)

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

    def solve(self, n, m):
        return self.n_c_k[n + m][n]


out = io.StringIO()
sol = Solution()
t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    ans = sol.solve(n, m)
    out.write(f'{ans}\n')

print(out.getvalue())