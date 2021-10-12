from io import StringIO


class Solution:
    def func(self, a, t):
        maxa, mina = 0, 10 ** 12
        for s, d in a:
            x = d + s * t
            maxa = max(x, maxa)
            mina = min(x, mina)

        return maxa - mina

    def search(self, k, a):
        l, r = 0, k
        eps = 10 ** -9
        while r - l > eps:
            m1 = l + (r - l) / 3
            m2 = r - (r - l) / 3
            if self.func(a, m1) < self.func(a, m2):
                r = m2
            else:
                l = m1
        return self.func(a, l)

    def solve(self):
        n, k = [int(_) for _ in input().split()]
        a = []
        for i in range(n):
            a.append([int(_) for _ in input().split()])

        print(f'{self.search(k, a):.6f}')


sol = Solution()
sol.solve()
