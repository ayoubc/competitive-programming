import io

class Solution:

    def solve(self, n):
        a = (n + 2) // 3 - 1
        b = (n + 4) // 5 - 1
        c = (n + 14) // 15 - 1
    
        A = (a * (a + 1)) // 2
        B = (b * (b + 1)) // 2
        C = (c * (c + 1)) // 2
        return 3 * A + 5 * B - 15 * C


t = int(input())
out = io.StringIO()
sol = Solution()
for tc in range(t):
    n = int(input())
    out.write(str(sol.solve(n)) + '\n')

print(out.getvalue())
