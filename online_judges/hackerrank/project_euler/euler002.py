import io

class Solution:
    def __init__(self):
        pass

    def solve(self, n):
        a, b = 1, 2
        ans = 2
        while True:
            c = a + b
            if c >= n:
                break
            if c % 2 == 0:
                ans += c
            a, b = b, c
        return ans


t = int(input())
out = io.StringIO()
sol = Solution()
for tc in range(t):
    n = int(input())
    out.write(str(sol.solve(n)) + '\n')

print(out.getvalue())
