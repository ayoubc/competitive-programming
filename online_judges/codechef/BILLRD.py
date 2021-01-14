import io


class Soltion:
    def get_periode(self, K):
        r = K % 4
        if r == 0:
            return 3
        return r - 1

    def solve(self, x, y, N, K):
        if x == y:
            return N, N
        elif x > y:
            sides = [(N, y+N-x), (y+N-x, N), (0, x-y), (x-y, 0)]
            return sides[self.get_periode(K)]
        else:
            sides = [(x + N - y, N), (N, x + N - y), (y - x, 0), (0, y - x)]
            return sides[self.get_periode(K)]


out = io.StringIO()
sol = Soltion()
t = int(input())
for _ in range(t):
    N, K,  x, y = map(int, input().split())
    X, Y = sol.solve(x, y, N, K)
    out.write(f'{X} {Y}\n')

print(out.getvalue())
