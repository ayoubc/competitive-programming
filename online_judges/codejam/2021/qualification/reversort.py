import io
from itertools import permutations


class Solution:

    def solve(self, n, l):
        ans = 0
        for i in range(n-1):
            index = i
            x = 1000
            for j in range(i, n):
                if x > l[j]:
                    index = j
                    x = l[j]
            rev = []
            for j in range(i, index + 1):
                rev.append(l[j])

            rev.reverse()

            for j in range(i, index + 1):
                l[j] = rev[j - i]

            ans += index - i + 1

        return ans


out = io.StringIO()
t = int(input())
sol = Solution()
for i in range(1, t+1):
    n = int(input())
    l = [int(x) for x in input().split()]
    ans = sol.solve(n, l)
    out.write(f'Case #{i}: {ans}\n')

print(out.getvalue())
