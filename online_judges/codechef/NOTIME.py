import io


class Solution:

    def solve(self, h, x, t):
        for t_ in t:
            if t_ + x >= h:
                return "YES"

        return "NO"

# out = io.StringIO()
sol = Solution()
# t = int(input())
# for _ in range(t):
#     n = int(input())
#     expr = input()
#     ans = sol.solve(n, expr)
#     out.write(f'{ans}\n')
n, h, x = [int(i) for i in input().split()]
t = [int(i) for i in input().split()]
ans = sol.solve(h, x, t)
print(ans)
# print(out.getvalue())
