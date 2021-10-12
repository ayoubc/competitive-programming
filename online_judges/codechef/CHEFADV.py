from math import sin, pi


class Solution:

    def solve(self, n, m, x, y):
        ans = 'Pofik'
        if ((n - 1) % x == 0 and (m - 1) % y == 0) or ((n - 2) % x == 0 and (m - 2) % y == 0 and n >= 2 and m >= 2):
            ans = 'Chefirnemo'
        print(ans)


sol = Solution()
for _ in range(int(input())):
    n, m, x, y = [int(x) for x in input().split()]
    sol.solve(n, m, x, y)
