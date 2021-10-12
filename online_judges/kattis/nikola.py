import sys
sys.setrecursionlimit(10 ** 6)


class Solution:
    def solve(self, n, cost):
        OO = 10 ** 9
        dp = {}
        def f(i, steps):
            if i < 1 or i > n:
                return OO

            if i == n:
                return cost[i]

            if (i, steps) in dp:
                return dp[(i, steps)]
            
            res1 = f(i + steps + 1, steps + 1)
            res2 = f(i - steps, steps)
            ans = cost[i] + min(res1, res2)
            dp[(i, steps)] = ans
            return ans

        return f(2, 1)

n = int(input())

sol = Solution()
a = [0]
for i in range(n):
    a.append(int(input()))

print(sol.solve(n, a))
