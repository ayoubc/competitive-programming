

class Solution:
    def __init__(self):
        N = 5 * 10 ** 5 + 1
        self.divs = [[1] for i in range(N)]
        for i in range(2, N):
            for j in range(i, N, i):
                self.divs[j].append(i)

    def solve(self, n, m):
        ans = 0
        for b in range(1, n+1):
            r = m % b
            xb = m - r
            if xb == 0:
                ans += b - 1
                continue
            divs = self.divs[xb]
            for a in divs:
                if a < b and (m % a) % b == r % a:
                    ans += 1

        return ans


sol = Solution()
for _ in range(int(input())):
    n, m = [int(x) for x in input().split()]
    print(sol.solve(n, m))
