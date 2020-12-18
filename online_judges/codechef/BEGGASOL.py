import io


class Solution:
    def __init__(self):
        pass

    def solve(self, n, f):
        cur = 0
        dist = 0
        i = 0
        while cur >= 0:
            dist = i
            cur += f[i % n]
            f[i % n] = 0
            i += 1
            cur -= 1
        return dist


out = io.StringIO()
sol = Solution()
t = int(input())
for tc in range(t):
    n = int(input())
    f = list(map(int, input().split()))
    out.write(str(sol.solve(n, f)) + '\n')

print(out.getvalue())
