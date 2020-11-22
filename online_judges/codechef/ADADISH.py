import io


class Solution:

    def __init__(self):
        pass

    def solve(self, c):
        c.sort(reverse=True)
        a, b = 0, 0
        for val in c:
            if a <= b:
                a += val
            else:
                b += val

        return max(a, b)


out = io.StringIO()
sol = Solution()
t = int(input())

for i in range(t):
    n = int(input())
    c = list(map(int, input().split()))
    out.write(str(sol.solve(c)) + '\n')
print(out.getvalue())
