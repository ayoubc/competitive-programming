import io
from sys import stdin, stdout
from itertools import permutations


class Solution:

    def solve(self, n, S):
        d = {}
        b = (1 << n)
        for i in range(1, b):
            tmp = []
            for j in range(n):
                if (1 << j) & i != 0:
                    tmp.append(S[j])

            s = "".join(tmp)
            tmp.sort()
            key = "".join(tmp)
            d[key] = min(s, d.get(key, s))

        ans = list(d.values())
        ans.sort()
        return ans


sol = Solution()
out = io.StringIO()
t = int(input())
for _ in range(t):
    n = int(input())
    S = input()
    ans = sol.solve(n, S)
    for s in ans:
        out.write(f'{s}\n')

print(out.getvalue())