import io


class Solution:
    REST = [0, 20, 36, 51]

    def solve(self, n):
        q = n // 4
        r = n % 4
        ans = 0
        if q >= 1:
            ans += (q - 1) * 44
            ans += 4 * (15 - r)

        ans += self.REST[r]
        return ans


out = io.StringIO()
sol = Solution()
for _ in range(int(input())):
    n = int(input())
    out.write(f'{sol.solve(n)}\n')
# print(sol.solve(n))
print(out.getvalue())
