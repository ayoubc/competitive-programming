import io
from math import sqrt, log10
# import fileinput
# for line in fileinput.input()


def extended_euclid(a, b):
    if b == 0:
        # a, x, y
        return a, 1, 0

    d, x1, y1 = extended_euclid(b, a % b)
    x = y1
    y = x1 - (a // b) * y1
    return d, x, y


def modular_inverse(a, n):
    d, x, y = extended_euclid(a, n)
    if d != 1:
        return None
    return (x + n) % n



class Solution:
    def valid(self, x, y):
        return 1 <= x <= self.n and 1 <= y <= self.n
    
    def solve(self, a, b, N):
        self.n = N
        x = modular_inverse(a, b)
        y = -(a * x - 1) // b
        k = 0
        l = []
        while x <= N and -y <= N:
            l.append((-y, x))
            k += 1
            x += b * k
            y -= a * k
        
        return f'{l[-1][0]} {l[-1][1]}'


out = io.StringIO()
t = int(input())
sol = Solution()
for _ in range(t):
    a, b, N = map(int, input().split())
    out.write(f'{sol.solve(a ,b, N)}\n')

print(out.getvalue())
