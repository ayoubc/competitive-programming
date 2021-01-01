import io
from sys import stdin

class Solution:
    def __init__(self, n):
        self.fact = [1] * (n+1)
        for i in range(1, n+1):
            self.fact[i] = self.fact[i - 1] * i

    def solve(self, n, k):
        ans = []
        id = [i + 1 for i in range(n)]
        while len(id) > 0:
            d = k // self.fact[len(id) - 1]
            k %= self.fact[len(id) - 1]
            ans.append(id.pop(d))

        return ans


out = io.StringIO()
sol = Solution(50)

for line in stdin:
    line = line.strip('\n')
    if line == '':
        break
    n, k = map(int, line.split())
    ans = " ".join(map(str, sol.solve(n, k)))
    out.write(f'{ans}\n')

print(out.getvalue())
