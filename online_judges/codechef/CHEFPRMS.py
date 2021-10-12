from math import sqrt


class Solution:
    def __init__(self):
        N = 201
        self.isprime = [True] * N
        self.isprime[0] = False
        self.isprime[1] = False
        for i in range(2, N):
            if self.isprime[i]:
                for j in range(i * i, N, i):
                    self.isprime[j] = False

    def is_semi_prime(self, n):
        q = int(sqrt(n))
        for i in range(2, q+1):
            if n % i == 0 and i * i != n:
                if self.isprime[i] and self.isprime[n // i]:
                    return True
        return False

    def solve(self, n):
        ans = 'NO'
        for i in range(n):
            if self.is_semi_prime(i) and self.is_semi_prime(n-i):
                ans = 'YES'
                break

        print(ans)


sol = Solution()
for _ in range(int(input())):
    # n, a, b, k = [int(x) for x in input().split()]
    sol.solve(int(input()))
