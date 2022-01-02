import sys
sys.setrecursionlimit(10 ** 6)


class Solution:
    def dfs(self, s):
        self.vis[s] = True
        self.cnt +=1
        for u in self.graph[s]:
            if not self.vis[u]:
                self.dfs(u)
                
    def solve(self, n, graph):
        self.vis = [False] * (n+1)
        self.graph = graph
        self.cnt = 0
        routes = 0
        cap = 1
        mod = 10 ** 9 + 7
        for i in range(1, n+1):
            if not self.vis[i]:
                self.cnt = 0
                self.dfs(i)
                routes += 1
                cap *= self.cnt
                cap %= mod

        return routes, cap
        


sol = Solution()
t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    graph = [[] for j in range(n+1)]
    for i in range(m):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)

    r, c = sol.solve(n, graph)
    print(r, c)
