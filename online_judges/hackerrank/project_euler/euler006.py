import io


class Solution:
    def __init__(self):
        pass

    def solve(self, n):
        a = (n * (n+1) * (2*n + 1)) // 6
        b = ((n * (n+1)) // 2) ** 2
        return abs(b - a)


t = int(input())
out = io.StringIO()
sol = Solution()
for tc in range(t):
    n = int(input())
    out.write(str(sol.solve(n)) + '\n')

print(out.getvalue())
