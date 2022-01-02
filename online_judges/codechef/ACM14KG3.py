from collections import defaultdict, deque


class Solution:
    def bfs(self, start):
        q = deque()
        q.append(start)
        vis = [False] * 26
        while len(q) > 0:
            cur = q.popleft()

            index = self.get_index(cur)
            if vis[index]:
                continue

            vis[index] = True
            adjs = self.edges.get(cur, [])
            for v in adjs:
                q.append(v)
            
        return vis

    def get_index(self, c):
        return ord(c) - ord('a')

    def get_char(self, i):
        return chr(i + ord('a'))
    
    def solve(self, s, t, mapping):
        n, m = len(s), len(t)
        self.edges = mapping
        if n != m:
            return "NO"

        dis = []
        for i in range(26):
            dis.append(self.bfs(self.get_char(i)))

        for i in range(n):
            if not dis[self.get_index(s[i])][self.get_index(t[i])]:
                return "NO"

        return "YES"
        

sol = Solution()

for _ in range(int(input())):
    s = input()
    t = input()
    m = int(input())
    mapping = defaultdict(list)
    for i in range(m):
        a, b = input().split('->')
        mapping[a].append(b)
        
    ans = sol.solve(s, t, mapping)
    print(ans)
