import io
from math import sqrt


class Solution:
    def __init__(self):
        pass

    def is_perfect(self, x):
        q = int(sqrt(x))
        return q ** 2 == x

    def solve(self, n):
        if n ** 2 % 2 != 0:
            return -1
        ans = -1
        for c in range(n // 3, n // 2):
            ab = n ** 2 - 2 * n * c
            delta = c ** 4 - ab ** 2
            if ab % 2 == 0 and delta >= 0 and self.is_perfect(delta):
                up1 = c ** 2 + int(sqrt(delta))
                if up1 % 2 == 0 and (ab ** 2) % (2 * up1) == 0:
                    a_square = up1 // 2
                    b_square = ab ** 2 // (2 * up1)
                    if a_square + b_square == c ** 2:
                        ans = max(ans, (ab // 2) * c)

        return ans


t = int(input())
out = io.StringIO()
sol = Solution()
for tc in range(t):
    n = int(input())
    out.write(str(sol.solve(n)) + '\n')

print(out.getvalue())
