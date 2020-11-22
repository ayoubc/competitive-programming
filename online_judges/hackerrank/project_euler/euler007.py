import io


class Solution:
    def __init__(self):
        pass

    def solve(self, n):
        is_prime = [True] * (n+1)
        primes = []
        for i in range(2, n+1):
            if is_prime[i]:
                primes.append(i)
                for j in range(2*i, n+1, i):
                    is_prime[j] = False
        return primes


t = int(input())
out = io.StringIO()
sol = Solution()
primes = sol.solve(10 ** 6)
for tc in range(t):
    n = int(input())
    out.write(str(primes[n-1]) + '\n')

print(out.getvalue())
