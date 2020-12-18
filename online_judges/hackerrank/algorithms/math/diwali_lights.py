import io
mod = 10 ** 5


def power(a, n):
    if n == 0:
        return 1
    b = power(a, n // 2)
    b = ((b % mod) * (b % mod)) % mod
    if n % 2 == 1:
        b = ((b % mod) * (a % mod)) % mod
    return b


class Solution:

    def solve(self, n):
        ans = power(2, n) - 1
        return (ans + mod) % mod


out = io.StringIO()
t = int(input())
sol = Solution()
for tc in range(t):
    n = int(input())
    ans = sol.solve(n)
    out.write(f'{ans}\n')

print(out.getvalue())
