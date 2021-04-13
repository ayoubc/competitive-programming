from io import StringIO


class Solution:
    def query(self, i, j, l):
        I, J = i + l - 1, j + l - 1

        res = self.prev[I][J]
        if j > 0:
            res -= self.prev[I][j-1]
        if i > 0:
            res -= self.prev[i-1][J]
        if i > 0 and j > 0:
            res += self.prev[i-1][j-1]

        return res

    def bi_seach_v(self, i, j):
        l, r = i, self.n - 1
        index, L = 0, 0
        while l <= r:
            mid = l + (r - l) // 2
            dim = mid - i + 1
            if dim > self.m - j:
                r = mid - 1

            elif self.query(i, j, dim) >= self.k * dim * dim:
                r = mid - 1
                index, L = mid, dim
            else:
                l = mid + 1

        return index, L

    def solve(self, n, m, k, matrix):
        self.prev = [list(range(m)) for _ in range(n)]
        self.n = n
        self.m = m
        self.k = k
        for j in range(m):
            self.prev[0][j] = matrix[0][j]

        for i in range(1, n):
            for j in range(m):
                self.prev[i][j] = matrix[i][j] + self.prev[i - 1][j]

        for i in range(n):
            for j in range(1, m):
                self.prev[i][j] += self.prev[i][j - 1]

        brute_force, ans = 0, 0
        for i in range(n):
            for j in range(m):
                index, dim = self.bi_seach_v(i, j)
                if dim > 0:
                    ans += min(n - i, m - j) - dim + 1

        return ans


out = StringIO()
sol = Solution()
for _ in range(int(input())):
    n, m, k = [int(_) for _ in input().split()]
    matrix = []
    for _ in range(n):
        matrix.append([int(_) for _ in input().split()])

    out.write(f'{sol.solve(n, m, k, matrix)}\n')
print(out.getvalue())
