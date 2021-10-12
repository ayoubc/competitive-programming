

class Solution:
    def solve(self, n, a):
        d = {}
        for e in a:
            d[e % 200] = d.get(e % 200, 0) + 1

        ans = 0
        for val in d.values():
            ans += (val * (val - 1)) // 2

        return ans


sol = Solution()
n = int(input())
a = [int(_) for _ in input().split()]
print(sol.solve(n, a))