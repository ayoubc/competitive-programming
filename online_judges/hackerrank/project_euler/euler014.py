import io


class Solution:

    def __init__(self, limit):
        self.limit = limit
        self.dp = [-1] * (limit + 1)
        self.ans = [(0, 0)] * (limit + 1)
        for i in range(2, limit+1):
            x = self.collatz(i)
            a, b = x, i
            if x < self.ans[i - 1][0]:
                a, b = self.ans[i - 1]

            self.ans[i] = (a, b)

    def collatz(self, n):
        if n == 1:
            return 0
        if n <= self.limit and self.dp[n] != -1:
            return self.dp[n]

        res = 0
        if n % 2 == 0:
            res = self.collatz(n >> 1) + 1
        else:
            res = self.collatz(3 * n + 1) + 1

        if n <= self.limit:
            self.dp[n] = res
        return res

    def solve(self, n):
        return self.ans[n][1]


out = io.StringIO()
sol = Solution(5000000)
t = int(input())
for i in range(t):
    n = int(input())
    out.write(str(sol.solve(n)) + '\n')
print(out.getvalue())
