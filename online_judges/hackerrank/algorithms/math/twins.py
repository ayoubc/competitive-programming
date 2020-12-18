import io
from math import sqrt


class Solution:
    def __init__(self):
        pass

    def segmented_sieve(self, l, r):
        q = int(sqrt(r)) + 1
        mark = [True] * q
        primes = []
        for p in range(2, q):
            if mark[p]:
                primes.append(p)
                for j in range(p * p, q, p):
                    mark[j] = False

        mark = [True] * (r - l + 1)
        for p in primes:
            start = max(p, (l + p - 1) // p) * p
            for j in range(start, r+1, p):
                mark[j - l] = False
        if l == 1:
            mark[0] = False
        return mark

    def solve(self, n, m):
        is_prime = self.segmented_sieve(n, m)
        ans = 0
        for i in range(n, m-1):
            if is_prime[i - n] and is_prime[i+2 - n]:
                ans += 1
        return ans


out = io.StringIO()
n, m = map(int, input().split())
sol = Solution()
print(sol.solve(n, m))
