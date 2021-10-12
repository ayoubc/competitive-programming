import sys
sys.setrecursionlimit(10 ** 6)


class Solution:
    def solve(self, n, arr):
        ans = [[] for i in range(n)]
        vis = [False] * n
        for i in range(n-1):
            a, b = [int(_) for _ in input().split()]
            ans[a - 1].append(b - 1)
            vis[b - 1] = True

        index = -1
        for e in range(n):
            if not vis[e]:
                index = e
                break

        def f(s):
            print(arr[s], end='')
            for i in ans[s]:
                f(i)
        f(index)
        
        


n = int(input())

sol = Solution()
a = []
for i in range(n):
    a.append(input())

sol.solve(n, a)
