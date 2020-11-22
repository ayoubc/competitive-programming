import io


class Solution:
    def __init__(self, a, n, x, p, k):
        self.a = a
        self.n = n
        self.x = x
        self.p = p
        self.k = k

    def find(self, value):
        diff = 2 * self.n
        index = -1
        for i in range(self.n):
            if self.a[i] == value:
                if diff > abs(self.p - i):
                    diff = abs(self.p - i)
                    index = i
        return index

    def solve(self, index):
        if index == -1:
            self.a[self.k] = self.x
            self.a.sort()
            res = self.solve(self.find(self.x))
            if res != -1:
                return res + 1
            return res

        else:
            if (index < self.p and self.k < self.p) or (index > self.p and self.k > self.p):
                return -1
            return abs(self.p - index)


out = io.StringIO()
t = int(input())
for i in range(t):
    n, x, p, k = map(int, input().split())
    a = list(map(int, input().split()))
    a.sort()
    sol = Solution(a, n, x, p-1, k-1)
    index = sol.find(x)
    out.write(str(sol.solve(index)) + '\n')

print(out.getvalue())
