from io import StringIO


class Solution:
    def __init__(self):
        N = 100001
        self.factors = [set() for i in range(N)]
        self.pre = [[0] * N for i in range(6)]
        for i in range(2, N):
            if len(self.factors[i]) == 0:
                self.factors[i].add(i)
                for j in range(2*i, N, i):
                    self.factors[j].add(i)

        for i in range(1, 6):
            self.pre[i][1] = 0
            for j in range(2, N):
                if len(self.factors[j]) == i:
                    self.pre[i][j] = self.pre[i][j - 1] + 1
                else:
                    self.pre[i][j] = self.pre[i][j - 1]

    def solve(self, a, b, k):
        return self.pre[k][b] - self.pre[k][a-1]


sol = Solution()
out = StringIO()
for _ in range(int(input())):
    a, b, k = [int(x) for x in input().split()]
    out.write(f'{sol.solve(a, b, k)}\n')

print(out.getvalue())

