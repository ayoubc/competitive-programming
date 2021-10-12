from io import StringIO


class Solution:

    def solve(self, n, a):
        prefix = [0] * n
        for i in range(n):
            if i == 0:
                prefix[i] = a[i]
            else:
                prefix[i] = a[i] + prefix[i-1]

        ans = 0
        m = None
        for i in range(n):
            x = prefix[i] + prefix[n - 1]
            if i > 0:
                x -= prefix[i - 1]

            if m is None or x < m:
                m = x
                ans = i

        return ans + 1


sol = Solution()
out = StringIO()
for i in range(int(input())):
    n = int(input())
    a = [int(y) for y in input().split()]
    out.write(f'{sol.solve(n, a)}\n')

print(out.getvalue())
