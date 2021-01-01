import io
from math import sqrt
# import fileinput
# for line in fileinput.input()
from collections import defaultdict


def factorization(n: int) -> dict:
    i = 2
    res = dict()
    while i * i <= n:
        while n % i == 0:
            res[i] = res.get(i, 0) + 1
            n //= i
        i += 1
    if n > 1:
        res[n] = res.get(n, 0) + 1
    return res


class Solution:
    def solve(self, n, a):
        prime_fact = [dict() for i in range(n)]

        total = dict()
        for i in range(n):
            prime_fact[i] = factorization(a[i])
            for prime in prime_fact[i]:
                if prime not in total:
                    total[prime] = []

        for prime in total:
            for i in range(n):
                total[prime].append(prime_fact[i].get(prime, 0))

        times = 0
        for prime in total:
            cnt = 0
            tmp = min(total[prime])
            while True:
                total[prime].sort()
                if tmp != total[prime][0]:
                    tmp = total[prime][0]
                    times += cnt
                    cnt = 0
                if total[prime][-1] - total[prime][0] >= 2:
                    cnt += 1
                    total[prime][0] += 1
                    total[prime][-1] -= 1
                else:
                    break

        ans = 1
        for prime in total:
            ans *= prime ** total[prime][0]

        return ans, times


sol = Solution()
n = int(input())
a = list(map(int, input().split()))
print(*sol.solve(n, a))
