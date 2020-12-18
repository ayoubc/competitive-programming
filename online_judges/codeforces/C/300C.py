import io
mod = 1000000007


def power(x, e):
    if e == 1:
        return x % mod
    tmp = power(x, e // 2)
    tmp = ((tmp % mod) * (tmp % mod)) % mod
    if e % 2 != 0:
        tmp = ((tmp % mod) * (x % mod)) % mod
    return tmp


class Solution:
    def __init__(self, n):
        fact = list(range(n + 1))
        fact[0], fact[1] = 1, 1
        for i in range(2, n + 1):
            fact[i] = fact[i - 1] * i
            fact[i] %= mod

        self.fact = fact

    def rCn(self, p, n):
        tmp = power(self.fact[n - p] * self.fact[p], mod - 2)
        return ((tmp % mod) * (self.fact[n] % mod)) % mod

    def is_good(self, x, a, b):
        s = str(x)
        return s.count(str(a)) + s.count(str(b)) == len(s)

    def solve(self, a, b, n):
        ans = 0
        for p in range(n+1):
            if self.is_good(p * a + (n - p) * b, a, b):
                ans += self.rCn(p, n)
                ans %= mod
        return ans


out = io.StringIO()
a, b, n = map(int, input().split())
sol = Solution(n)
print(sol.solve(a, b, n))
