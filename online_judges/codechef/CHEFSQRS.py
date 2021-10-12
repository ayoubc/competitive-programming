from math import sqrt


class Solution:

    def solve(self, n):
        ans = None
        q = int(sqrt(n))
        divs = []
        for i in range(1, q+1):
            if n % i == 0:
                divs.append(i)
                if i * i != n:
                    divs.append(n // i)

        for d in divs:
            if (d + n // d) % 2 == 0:
                q = (d + n // d) // 2
                p = d - q
                if p > 0:
                    ans = p if ans is None else min(ans, p)

        print(-1 if ans is None else ans ** 2)


sol = Solution()
for _ in range(int(input())):
    # n, a, b, k = [int(x) for x in input().split()]
    sol.solve(int(input()))
