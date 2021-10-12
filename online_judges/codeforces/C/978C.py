from bisect import bisect_left
from io import StringIO


class Solution:

    def solve(self, n, m, a, b):
        pre = [0] * n
        pre[0] = a[0]
        for i in range(1, n):
            pre[i] = pre[i - 1] + a[i]

        out = StringIO()
        for i in range(m):
            j = bisect_left(pre, b[i])

            k = b[i] - (pre[j - 1] if j >= 1 else 0)

            out.write(f'{j+1} {k}\n')

        print(out.getvalue())


sol = Solution()

n, m = [int(_) for _ in input().split()]
a = [int(_) for _ in input().split()]
b = [int(_) for _ in input().split()]

sol.solve(n, m, a, b)
