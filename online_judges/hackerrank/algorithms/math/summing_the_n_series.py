import io


class Solution:

    def solve(self, n):
        mod = 10 ** 9 + 7
        return ((n % mod) * (n % mod)) % mod


out = io.StringIO()
t = int(input())
sol = Solution()
for tc in range(t):
    n = int(input())
    ans = sol.solve(n)
    out.write(f'{ans}\n')

print(out.getvalue())
