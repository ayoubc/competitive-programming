import io

class Solution:
    def __init__(self):
        pass

    def prime_factorisation(self, n):
        res = dict()
        i = 2
        while i * i <= n:
            if n % i == 0:
                k = 0
                while n % i == 0:
                    k += 1
                    n //= i
                res[i] = k
            i += 1
        if n > 1:
            res[n] = res.get(n, 0) + 1
        return res

    def solve(self, n):
        d = {}
        for i in range(2, n+1):
            res = self.prime_factorisation(i)
            for prime in res:
                d[prime] = max(d.get(prime, 0), res[prime])

        p = 1
        for prime in d:
            p *= prime ** d[prime]
        return p


t = int(input())
out = io.StringIO()
sol = Solution()
for tc in range(t):
    n = int(input())
    out.write(str(sol.solve(n)) + '\n')

print(out.getvalue())
