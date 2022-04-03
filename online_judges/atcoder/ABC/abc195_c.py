import io


class Solution:

    def solve(self, n):
        d = 0
        ans = 0
        while True:
            x = 10 ** d
            y = x * (10 ** 3)
            if y > n:
                ans += (n - x + 1) * (d // 3)
                break

            ans += (y - x) * (d // 3)
            d += 3

        return ans


out = io.StringIO()
sol = Solution()

n = int(input())
print(sol.solve(n))