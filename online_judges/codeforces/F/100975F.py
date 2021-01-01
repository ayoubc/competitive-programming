# Codeforces GYM link: https://codeforces.com/gym/100975
import io
from math import log2
from sys import stdin, stdout

stdin = open('calc.in')
stdout = open('calc.out', 'w')


def phi(n):
    ans = n
    i = 2
    while i * i <= n:
        if n % i == 0:
            while n % i == 0:
                n //= i

            ans -= ans // i
        i += 1
    if n > 1:
        ans -= ans // n
    return ans


def power(x, n, mod):
    if n == 0:
        return 1 % mod

    tmp = power(x, n // 2, mod)
    tmp = ((tmp % mod) * (tmp % mod)) % mod
    if n % 2 != 0:
        tmp = ((tmp % mod) * (x % mod)) % mod
    return tmp


class Solution:

    def solve(self, n, k):
        if k == 1 or (log2(k) > 0.0 and n >= log2(log2(k))):
            phi_k = phi(k)
            tmp = power(2, n, phi_k)
            return (power(2, phi_k + tmp, k) % k + 1 % k) % k
        else:
            return ((1 << (1 << n)) + 1) % k


sol = Solution()
n, k = map(int, stdin.readline().strip('\n').split())
stdout.write(str(sol.solve(n, k)))
