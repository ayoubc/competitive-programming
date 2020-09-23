from collections import defaultdict

def solve(L, n):
    vis = [False]*n
    def dfs(s):
        vis[s] = True
        for i in L[s]:
            if not vis[i]:
                dfs(i)

    ans = 0
    for i in range(n):
        if not vis[i]:
            ans += 1
            dfs(i)
    return ans

t = int(input())

for i in range(t):
    n, m = map(int, input().split())
    adjList = defaultdict(list)

    for k in range(m):
        a, b = map(int, input().split())
        adjList[a].append(b)
        adjList[b].append(a)

    print(solve(adjList, n))