import io
from math import sqrt, log10
# import fileinput
# for line in fileinput.input()


def extended_euclid(a, b):
    if b == 0:
        # a, x, y
        return a, 1, 0

    d, x1, y1 = extended_euclid(b, a % b)
    x = y1
    y = x1 - (a // b) * y1
    return d, x, y


def modular_inverse(a, n):
    d, x, y = extended_euclid(a, n)
    if d != 1:
        return None
    return (x + n) % n


def chinese_reminder(a, p):
    k = len(p)
    inv = [list(range(k)) for j in range(k)]
    for i in range(k):
        for j in range(k):
            if i != j:
                inv[i][j] = modular_inverse(p[i], p[j])

    x = list(range(k))
    for i in range(k):
        x[i] = a[i]
        for j in range(i):
            x[i] = inv[j][i] * (x[i] - x[j])
            x[i] %= p[i]
            if x[i] < 0:
                x[i] += p[i]

    ans = x[0]
    prod = 1
    K = 1
    for i in range(k):
        K *= p[i]

    for i in range(1, k):
        prod *= p[i-1]
        ans += x[i] * prod
        ans %= K
    return ans


def segmented_sieve(l, r):
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
        for j in range(start, r + 1, p):
            mark[j - l] = False
    if l == 1:
        mark[0] = False

    ans = []
    for i in range(l, r + 1):
        if mark[i - l]:
            ans.append(i)
    return ans


class Solution:
    def get_s(self, p1, p2):
        k = int(log10(p1)) + 1
        a = [0, p1]
        p = [p2, 10 ** k]
        return chinese_reminder(a, p)

    def solve(self, l, r):
        primes = segmented_sieve(l, r + 500)
        n = len(primes)
        res = 0
        for i in range(n-1):
            if l <= primes[i] <= r:
                res += self.get_s(primes[i], primes[i+1])
        return res


out = io.StringIO()
t = int(input())
sol = Solution()
for _ in range(t):
    l, r = map(int, input().split())
    out.write(f'{sol.solve(l ,r)}\n')

print(out.getvalue())
