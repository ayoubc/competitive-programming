import io
from copy import deepcopy


class Solution:
    dx = [0, -1, 0, 1]
    dy = [1, 0, -1, 0]

    def __init__(self, n, grid):
        self.n = n
        self.grid = grid
        self.used = []
        for i in range(self.n):
            self.used.append([False] * self.n)

    def is_valid(self, i, j):
        return (
                (0 <= i < self.n)
               and (0 <= j < self.n)
               and self.grid[i][j] == 0
        )

    def f(self, i, j):
        if i == self.n-1 and j == self.n-1:
            return 1

        res = 0
        self.used[i][j] = True
        for k in range(4):
            I, J = self.dx[k] + i, self.dy[k] + j
            if self.is_valid(I, J) and not self.used[I][J]:
                res += self.f(I, J)
        self.used[i][j] = False
        return res

    def solve(self):
        return self.f(0, 0)


N = int(input())
grid = []
for i in range(N):
    grid.append([int(x) for x in input().split()])

sol = Solution(N, grid)
print(sol.solve())
