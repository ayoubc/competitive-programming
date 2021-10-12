from io import StringIO

MOD = 1000000007


class Solution:
    def power(self, x, n):
        if n == 0:
            return 1
        if n == 1:
            return x % MOD

        b = self.power(x, n // 2)
        b = ((b % MOD) * (b % MOD)) % MOD
        if n % 2 == 1:
            b = ((x % MOD) * (b % MOD)) % MOD

        return b

    def solve(self, n):
        return self.power(2, n - 1)


sol = Solution()
out = StringIO()
for _ in range(int(input())):
    out.write(f'{sol.solve(int(input()))}\n')

print(out.getvalue())