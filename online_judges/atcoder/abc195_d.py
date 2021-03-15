import io
from collections import defaultdict

def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)


class Solution:

    def solve(self, N, M, Q, X, baggages, queries):
        baggages.sort(key=lambda t: t[1], reverse=True)
        res = []
        for q in queries:
            l, r = q
            rem_x = [X[i-1] for i in range(1, M+1) if i < l or i > r]
            rem_x.sort()
            ans = 0
            vis = [False] * len(rem_x)
            for b in baggages:
                for i in range(len(rem_x)):
                    if not vis[i] and b[0] <= rem_x[i]:
                        ans += b[1]
                        vis[i] = True
                        break

            res.append(ans)

        return res


out = io.StringIO()
sol = Solution()
N, M, Q = [int(x) for x in input().split()]
baggages = []
for i in range(N):
    W, V = [int(x) for x in input().split()]
    baggages.append((W, V))

X = [int(x) for x in input().split()]
queries = []
for i in range(Q):
    L, R = [int(x) for x in input().split()]
    queries.append((L, R))

print(*sol.solve(N, M, Q, X, baggages, queries), sep='\n')
