from collections import deque

class Solution:
    
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        visited = [[False] * n for i in range(m)]
        ans = 0
        dx = [0, -1, 0, 1]
        dy = [1, 0, -1, 0]
        def valid(i, j):
            return i>=0 and i<m and j>=0 and j<n and grid[i][j] == 1
        
        def bfs(i, j):
            q = deque()
            res = 1
            visited[i][j] = True
            q.append((i, j))
            while len(q) > 0:
                I, J = q.popleft()
                
                for k in range(4):
                    I_, J_ = I + dx[k], J + dy[k]
                    if valid(I_, J_) and not visited[I_][J_]:
                        visited[I_][J_] = True
                        q.append((I_, J_))
                        res += 1
            
            return res
        
        for i in range(m):
            for j in range(n):
                if not visited[i][j] and grid[i][j] == 1:
                    ans = max(ans, bfs(i, j))
        
        return ans