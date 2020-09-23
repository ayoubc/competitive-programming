# from sys import stdin, stdout
# stdin = open('in.txt', 'r')
# stdout = open('perimetric_chapter_1_output.txt', 'w')
from math import sqrt

class Solution:
    def __init__(self):
        pass

    def acc_sum(self, m):
        return (m * (m + 1)) // 2

    def n_c_r(self, m):
        if m < 2:
            return 1
        return (m * (m - 1)) // 2

    def equal_part(self, k):
        q = int(sqrt(1 + 8 * k))
        if q * q == 1 + 8 * k and q % 2 != 0:
            return (q - 1) // 2
        return 0

    def solve(self, n):
        if n % 4 == 1 or n % 4 == 2:
            return 0

        k = (n * (n + 1)) // 4
        ans = 0
        tmp1 = int((sqrt(1 + 8 * (k - n + 1)) - 1) / 2)
        tmp2 = int((sqrt(1 + 8 * (k - 1)) - 1) / 2)
        for m in range(tmp1, tmp2 + 1, 1):
            a = self.acc_sum(m)
            if a == k:
                continue
            else:
                x1 = max(m + 1 - k + a, 1)
                x2 = min(m, n - k + a)
                ans += max(x2 - x1 + 1, 0)

        m = self.equal_part(k)
        if m != 0:
            ans += self.n_c_r(m) + self.n_c_r(n - m)
        return ans



out = Solution()
t = int(input())
for i in range(t):
    n = int(input())
    print(out.solve(n))


