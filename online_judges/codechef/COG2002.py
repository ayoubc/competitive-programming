from io import StringIO


class Solution:
    def solve(self, n, x):
        ans = 0
        for i in range(n):
            j = (i + 1) % n
            k = (i + 2) % n
            ans = max(ans, x[i] + x[j] + x[k])

        return ans


sol = Solution()
out = StringIO()
for _ in range(int(input())):
    n = int(input())
    x = [int(y) for y in input().split()]
    out.write(f'{sol.solve(n, x)}\n')

print(out.getvalue())

