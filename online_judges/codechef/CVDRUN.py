import io


class Solution:
    def __int__(self):
        pass

    def solve(self, n, k, x, y):
        vis = [False] * n
        while True:
            x = (x + k) % n
            if vis[x]:
                break
            vis[x] = True
        return vis[y]


sol = Solution()
t = int(input())
out = io.StringIO()
for i in range(t):
    n, k, x, y = map(int, input().split())
    res = "YES" if sol.solve(n, k, x, y) else "NO"
    out.write(res + '\n')

print(out.getvalue())
