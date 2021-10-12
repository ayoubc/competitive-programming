

class Solution:
    def solve(self, n):
        k = 0
        ans = 0
        while True:
            a = (1 << k)
            if a > n:
                break

            ans = max(ans, min(n, 2 * a - 1) - a + 1)
            k += 1

        return ans

t = int(input())

sol = Solution()

for _ in range(t):
    print(sol.solve(int(input())))
