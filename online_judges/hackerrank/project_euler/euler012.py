import io


class Solution:

    def __init__(self, limit):
        self.first_over = dict()
        for i in range(1, limit+1):
            x = (i * (i + 1)) // 2
            d = self.divs(x)
            self.first_over[d] = self.first_over.get(d, x)

        self.num_divs = list(self.first_over.keys())

    def divs(self, n):
        cnt = 1
        i = 2
        while i * i <= n:
            p = 0
            while n % i == 0:
                p += 1
                n //= i
            cnt *= (p + 1)
            i += 1

        if n > 1:
            cnt *= 2
        return cnt

    def solve(self, n):
        for d in self.num_divs:
            if d > n:
                return self.first_over[d]


out = io.StringIO()
sol = Solution(41040)
t = int(input())
for i in range(t):
    n = int(input())
    out.write(str(sol.solve(n)) + '\n')

print(out.getvalue())
