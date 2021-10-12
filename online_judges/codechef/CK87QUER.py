from io import StringIO
from math import sqrt


class Solution:

    def solve(self, y):
        ans = 0
        for b in range(1, 701):
            if y >= b:
                ans += int(sqrt(y - b))

        return ans


sol = Solution()
out = StringIO()
for i in range(int(input())):
    out.write(f'{sol.solve(int(input()))}\n')

print(out.getvalue())
