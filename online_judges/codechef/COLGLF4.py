import io


class Solution:
    NOT_FOUND = 10 ** 18

    def solve(self, n, e, h, prices):
        ans = self.NOT_FOUND

        for c in range(min(e, h, n) + 1):
            A = (e - c) // 2
            B = (h - c) // 3
            if A + B + c >= n:
                if prices[0] < prices[1]:
                    a = min(A, n - c)
                    b = max(0, min(B, n - c - a))
                else:
                    b = min(B, n - c)
                    a = max(0, min(A, n - c - b))

                cost = a * prices[0] + b * prices[1] + c * prices[2]
                ans = min(ans, cost)

        if ans == self.NOT_FOUND:
            return -1
        return ans


out = io.StringIO()
t = int(input())
sol = Solution()
for _ in range(t):
    n, e, h, *prices = [int(x) for x in input().split()]
    ans = sol.solve(n, e, h, prices)
    out.write(f'{ans}\n')

print(out.getvalue())
