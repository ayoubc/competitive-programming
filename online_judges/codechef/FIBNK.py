mod = 1000000007


class Solution:
    def __init__(self):
        self.memo = {}

    def fibo(self, i):
        if i <= 1:
            return i

        ans = self.memo.get(i)
        if ans is not None:
            return ans

        if i % 2 == 0:
            k = i // 2
            a, b = self.fibo(k - 1), self.fibo(k)
            ans = (2 * a + b) * b

        else:
            k = (i + 1) // 2
            a, b = self.fibo(k - 1), self.fibo(k)
            ans = a * a + b * b

        ans %= mod
        self.memo[i] = ans
        return ans

    def solve(self, n, k):
        a = self.fibo((n % k) + 1)
        ans = a - 1 if a - 1 >= 0 else a - 1 + mod
        if n < k:
            return ans

        b = self.fibo(k+1)
        q = n // k
        ans += q * (b - 1 if b - 1 >= 0 else b - 1 + mod)
        return ans % mod


sol = Solution()
for _ in range(int(input())):
    n, k = [int(_) for _ in input().split()]
    print(sol.solve(n, k))
