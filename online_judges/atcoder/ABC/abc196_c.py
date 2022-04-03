import io


class Solution:

    def solve(self, N):
        limit = 10 ** 6
        ans = 0
        for i in range(1, min(N + 1, limit + 1)):
            if int(str(i) * 2) <= N:
                ans += 1
        return ans


sol = Solution()
x = int(input())
print(sol.solve(x))