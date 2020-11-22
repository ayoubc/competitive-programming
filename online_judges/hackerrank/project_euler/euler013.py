import io


class Solution:

    def __init__(self):
        self.ans = 0

    def solve(self, n):
        self.ans += n


out = io.StringIO()
sol = Solution()
t = int(input())
for i in range(t):
    n = int(input())
    sol.solve(n)
out.write(str(sol.ans)[:10] + '\n')
print(out.getvalue())
