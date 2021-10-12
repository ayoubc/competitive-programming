from io import StringIO


class Matrix:
    mod = 10

    def __init__(self, m=None):
        if m is None:
            m = [
                [1, 0],
                [0, 1]
            ]

        self.list = m
        self.n = len(m)

    def __mul__(self, other):
        n = Matrix()
        for i in range(self.n):
            for j in range(self.n):
                x = 0
                for k in range(self.n):
                    x += (self.list[i][k] * other.list[k][j]) % self.mod
                n.list[i][j] = x % self.mod
        return n

    def __pow__(self, power, modulo=None):
        if power == 0:
            return Matrix()

        b = self.__pow__(power // 2)
        b = b * b
        if power % 2 != 0:
            b = b * self

        return b

    def __getitem__(self, item):
        i, j = item
        return self.list[i][j]


def fibo(n):
    if n == 0:
        return 0
    if n == 1:
        return 1

    m = Matrix([[1, 1], [1, 0]])
    c = m ** (n - 1)
    return c[(0, 0)]


class Solution:
    def __init__(self):
        self.dp = [0] * 65
        for i in range(65):
            self.dp[i] = fibo((1 << i) - 1)

    def solve(self, n):
        p = 0
        while (1 << p) <= n:
            p += 1

        p -= 1
        return self.dp[p]


sol = Solution()
out = StringIO()
for _ in range(int(input())):
    n = int(input())
    out.write(f'{sol.solve(n)}\n')

print(out.getvalue())
