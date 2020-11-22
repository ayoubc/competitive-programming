import io
import bisect


class Solution:
    def __init__(self, n):
        is_prime = [True] * (n + 1)
        primes = []
        prev = [0]
        for i in range(2, n + 1):
            if is_prime[i]:
                primes.append(i)
                prev.append(i + prev[-1])
                for j in range(2 * i, n + 1, i):
                    is_prime[j] = False
        self.primes = primes
        self.prev = prev

    def solve(self, n):
        index = bisect.bisect_left(self.primes, n)
        if self.primes[index] > n:
            index -= 1
        return self.prev[index+1]


out = io.StringIO()
sol = Solution(10 ** 6)
t = int(input())
for tc in range(t):
    n = int(input())
    out.write(str(sol.solve(n)) + '\n')

print(out.getvalue())
