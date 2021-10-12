from io import StringIO


class Solution:

    def solve(self, grid):
        d = {'X': 0, 'O': 0, '_': 0}
        for i in range(3):
            for j in range(3):
                d[grid[i][j]] += 1

        wins = {'X': 0, 'O': 0}
        # lines
        for i in range(3):
            s = set(grid[i])
            s = list(s)
            if len(s) == 1 and s[0] != '_':
                wins[s[0]] = 1

        # columns
        for j in range(3):
            s = set()
            for i in range(3):
                s.add(grid[i][j])

            s = list(s)
            if len(s) == 1 and s[0] != '_':
                wins[s[0]] = 1

        # left diagonal
        s = set()
        for i in range(3):
            s.add(grid[i][i])

        s = list(s)
        if len(s) == 1 and s[0] != '_':
            wins[s[0]] = 1

        # right diagonal
        s = set()
        for i in range(3):
            s.add(grid[i][2 - i])

        s = list(s)
        if len(s) == 1 and s[0] != '_':
            wins[s[0]] = 1

        if (wins['X'] == 1 and wins['O'] == 1) or (d['X'] < d['O']) or (d['X'] - d['O'] >= 2):
            return 3

        elif wins['O'] == 1 and wins['X'] == 0 and d['O'] == d['X']:
            return 1

        elif wins['X'] == 1 and wins['O'] == 0 and d['X'] - d['O'] == 1:
            return 1

        elif wins['X'] == 0 and wins['O'] == 0 and d['_'] == 0:
            return 1

        elif wins['X'] == 0 and wins['O'] == 0 and d['_'] > 0:
            return 2

        return 3


sol = Solution()
out = StringIO()
for _ in range(int(input())):
    grid = []
    for i in range(3):
        grid.append(list(input()))
    out.write(f'{sol.solve(grid)}\n')

print(out.getvalue())
