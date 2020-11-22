import io


class Solution:
    def __init__(self):
        pass

    def get_prodcut(self, str_):
        p = 1
        for i in str_:
            p *= int(i)
        return p

    def solve(self, x, n, k):
        ans = 0
        for i in range(n - k):
            ans = max(ans, self.get_prodcut(x[i: i+k]))
        return ans


t = int(input())
out = io.StringIO()
sol = Solution()
for tc in range(t):
    n, k = map(int, input().split())
    x = input()
    out.write(str(sol.solve(x, n, k)) + '\n')

print(out.getvalue())
