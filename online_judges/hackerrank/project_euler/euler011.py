import io


class Solution:
    def __init__(self):
        pass

    def solve(self, grid):
        ans = None
        # left or right
        for i in range(20):
            for j in range(17):
                cnt = 1
                for k in range(4):
                    cnt *= grid[i][j+k]
                if ans is None:
                    ans = cnt
                else:
                    ans = max(ans, cnt)
        # up or down
        for i in range(17):
            for j in range(20):
                cnt = 1
                for k in range(4):
                    cnt *= grid[i+k][j]
                ans = max(ans, cnt)
        # diagonaly left
        for i in range(17):
            for j in range(17):
                cur1 = grid[i][j] * grid[i + 1][j + 1] * grid[i + 2][j + 2] * grid[i + 3][j + 3]
                cur2 = grid[i][j + 3] * grid[i + 1][j + 2] * grid[i + 2][j + 1] * grid[i + 3][j]
                ans = max(ans, max(cur1, cur2))

        return ans


out = io.StringIO()
sol = Solution()
grid = []
for i in range(20):
    line = list(map(int, input().split()))
    grid.append(line)

out.write(str(sol.solve(grid)) + '\n')
print(out.getvalue())
