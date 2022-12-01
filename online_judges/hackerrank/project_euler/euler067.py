import io


class Solution:
   
    def solve(self, n, grid):
        dp = [[0] * n for i in range(n)]
        dp[0][0] = grid[0][0]
        for i in range(1, n, 1):
            for j in range(len(grid[i])):
                dp[i][j] = grid[i][j]
                add = dp[i-1][j-1]
                if j < len(grid[i-1]):
                    add = max(add, dp[i-1][j])

                dp[i][j] += add

        return max(dp[n-1])


t = int(input())
out = io.StringIO()
sol = Solution()
for tc in range(t):
    n = int(input())
    grid = []
    for i in range(n):
        grid.append(list(map(int, input().split())))
    
    out.write(str(sol.solve(n, grid)) + '\n')

print(out.getvalue())
