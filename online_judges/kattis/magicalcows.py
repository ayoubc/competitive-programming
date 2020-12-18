import io
import fileinput
from collections import deque


class Solution:

    def solve(self, C, n, m, c, d):
        if n == 0:
            return [0 for day in d]
        p = [0 for i in range(n)]
        for i in range(n):
            k = 0
            while (1 << k) * c[i] <= C:
                k += 1
            p[i] = k

        P = max(p)
        # print(p)
        cnt = [1 for i in range(n)]
        days = [0 for i in range(51)]
        for i in range(P):
            for j in range(n):
                if p[j] <= i:
                    cnt[j] *= 2
            for j in range(n):
                days[i] += cnt[j]

        for i in range(P, 51):
            days[i] = days[i - 1] * 2

        return [days[day] for day in d]


sol = Solution()
C, N, M = map(int, input().split())
c = []
for i in range(N):
    c.append(int(input()))
d = []
for i in range(M):
    d.append(int(input()))

print(*sol.solve(C, N, M, c, d), sep='\n')
