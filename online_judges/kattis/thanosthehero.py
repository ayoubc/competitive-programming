import io


class Solution:

    def solve(self, n, a):
        ans = 0
        for i in range(n-1, 0, -1):
            if a[i] <= a[i-1]:
                ans += a[i-1] - a[i] + 1
                a[i - 1] = a[i] - 1
        for i in range(n):
            if a[i] < 0:
                return 1
        return ans


out = io.StringIO()
n = int(input())
a = list(map(int, input().split()))
sol = Solution()
print(sol.solve(n, a))