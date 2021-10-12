from collections import deque
import sys

sys.setrecursionlimit(10**6)

MOD = 1000000007


class Solution:

    def solve(self, tree, n, x):
        values = [0] * n

        def dfs(s, e):
            values[s] = 1
            tmp = []
            for u in tree[s]:
                if u == e:
                    continue

                dfs(u, s)
                tmp.append(values[u])

            tmp.sort(reverse=True)
            for i in range(len(tmp)):
                values[s] += (i+1) * tmp[i]

        dfs(0, -1)
        return (values[0] * x) % MOD


sol = Solution()
for _ in range(int(input())):
    n, x = [int(y) for y in input().split()]
    tree = [[] for i in range(n)]
    for i in range(n-1):
        u, v = [int(y) for y in input().split()]
        tree[u-1].append(v-1)
        tree[v-1].append(u-1)

    print(sol.solve(tree, n, x))
