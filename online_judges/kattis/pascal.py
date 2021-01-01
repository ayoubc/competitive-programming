import io


class Solution:

    def solve(self, n):
        if n == 1:
            return 0
        d = 1
        i = 2
        while i * i <= n:
            if n % i == 0:
                d = max(d, i, n // i)

            i += 1
        return n - d


n = int(input())
sol = Solution()
print(sol.solve(n))
