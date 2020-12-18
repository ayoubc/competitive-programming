import io


class Solution:

    def solve(self, a, b):
        even_a = a // 2
        even_b = b // 2
        return even_a * even_b + (a - even_a) * (b - even_b)


out = io.StringIO()
sol = Solution()
t = int(input())
for tc in range(t):
    a, b = map(int, input().split())
    out.write(str(sol.solve(a, b)) + '\n')

print(out.getvalue())
