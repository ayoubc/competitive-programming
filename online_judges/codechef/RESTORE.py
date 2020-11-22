import io


class Solution:

    def __init__(self):
        self.limit = 4 * 10 ** 6
        self.primes = []
        self.is_prime = [True] * (self.limit + 1)
        for i in range(2, self.limit + 1):
            if self.is_prime[i]:
                self.primes.append(i)

                for j in range(2 * i, self.limit + 1, i):
                    self.is_prime[j] = False

    def solve(self, n, b):

        d = {}
        for i in range(n):
            d[b[i]] = d.get(b[i], []) + [i]

        cur_prime = 0
        ans = [0] * n
        for key in d.keys():
            for i in d[key]:
                ans[i] = self.primes[cur_prime]
            cur_prime += 1
        return ans


out = io.StringIO()
sol = Solution()
t = int(input())
for i in range(t):
    n = int(input())
    b = list(map(int, input().split()))
    print(*sol.solve(n, b))
