import io

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]


class Solution:
    def solve(self, X, Y):
        if X < Y:
            return 2, [X, Y]

        ans = None
        for d in range(4, X+2):
            if Y - 2 + d > X + 2:
                ans = [1, 2, 3, d, X + 2, Y - 2 + d]
                break

        if ans is None:
            return 0, ['NO PATH']

        return len(ans), ans


out = io.StringIO()
t = int(input())

for tc in range(t):
    k, x, y = map(int, input().split())
    sol = Solution()
    res = sol.solve(x, y)
    ans = " ".join(list(map(str, res[1])))
    if res[0] > 0:
        out.write(f'{k} {res[0]} {ans}\n')
    else:
        out.write(f'{k} {ans}\n')

print(out.getvalue())
