from io import StringIO


class Solution:
    def query(self, i, j, occ):
        if i == 0:
            return occ[j]
        return occ[j] - occ[i-1]

    def solve(self, n, m, k, g, intervals):
        ans = 0
        scores = []
        for b in range(1<<n):
            occ = [0] * n
            score = 0
            for i in range(n):
                if b & (1 << i) == 0:
                    if i == 0:
                        occ[i] = 1
                    else:
                        occ[i] = occ[i - 1] + 1
                else:
                    if i > 0:
                        occ[i] = occ[i - 1]

                    score += g[i]

            for interval in intervals:
                u, v, d = interval
                zero = self.query(u-1, v-1, occ)
                if zero == 0:
                    score += d

            scores.append(score)

        scores.sort(reverse=True)
        print(*scores[:k])


sol = Solution()
for _ in range(int(input())):
    n, m, k = [int(_) for _ in input().split()]
    g = [int(_) for _ in input().split()]
    intervals = []
    for i in range(m):
        intervals.append([int(x) for x in input().split()])

    sol.solve(n, m, k, g, intervals)
