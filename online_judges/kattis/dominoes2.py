import sys
sys.setrecursionlimit(10 ** 6)



class Solution:
    def solve(self, n, l, hand, graph):
        self.vis = [False] * (n + 1)
        self.cnt = 0
        def dfs(start):
            self.vis[start] = True
            self.cnt += 1
            for u in graph[start]:
                if not self.vis[u]:
                    dfs(u)
        ans = 0
        for i in range(l):
            if not self.vis[hand[i]]:
                self.cnt = 0
                dfs(hand[i])
                ans += self.cnt

        return ans


sol = Solution()
for _ in range(int(input())):
    n, m, l = map(int, input().split())
    graph = [[] for i in range(n+1)]
    for i in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
    hand = []
    for i in range(l):
        hand.append(int(input()))
        
    print(sol.solve(n, l, hand, graph))
