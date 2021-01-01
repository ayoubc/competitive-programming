import io
from math import sqrt


class Solution:

    def solve(self, l, a):
        cnt = 0
        N, M = None, None
        for b in range(1, l[2]):
            if b % l[0] == 0 and (l[2] - b) % l[1] == 0:
                n = b // l[0]
                m = (l[2] - b) // l[1]
                if n * a[0] + m * a[1] == a[2]:
                    N = n
                    M = m
                    cnt += 1

        if cnt == 1:
            return f'{N} {M}'
        else:
            return '?'


out = io.StringIO()
sol = Solution()
t = int(input())
for _ in range(t):
    x = [int(x) for x in input().split()]
    l = [x[i] for i in range(6) if i % 2 == 0]
    a = [x[i] for i in range(6) if i % 2 != 0]
    out.write(f'{sol.solve(l, a)}\n')

print(out.getvalue())

