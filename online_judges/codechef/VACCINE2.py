import io


class Solution:

    def solve(self, a, n, d):
        risk = 0
        for age in a:
            if age >= 80 or age <= 9:
                risk += 1
        return (risk + d - 1) // d + (n - risk + d - 1) // d


out = io.StringIO()
sol = Solution()
t = int(input())
for tc in range(t):
    n, d = map(int, input().split())
    a = list(map(int, input().split()))

    out.write(str(sol.solve(a, n, d)) + '\n')

print(out.getvalue())
