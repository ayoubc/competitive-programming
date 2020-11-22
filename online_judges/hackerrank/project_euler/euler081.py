
def solution(grid, n):
    
    dp = [[0 for i in range(n)] for j in range(n)]
    dp[0][0] = grid[0][0]
    for i in range(1, n):
        dp[0][i] = grid[0][i] + dp[0][i - 1]
    for i in range(1, n):
        dp[i][0] = grid[i][0] + dp[i - 1][0]

    for i in range(1, n):
        for j in range(1, n):
            dp[i][j] = grid[i][j] + min(dp[i - 1][j], dp[i][j - 1])

    return dp[n - 1][n - 1]


n = int(input())
grid = []
for i in range(n):
    row = input().split()
    grid.append(list(map(int, row)))

print(solution(grid, n))
