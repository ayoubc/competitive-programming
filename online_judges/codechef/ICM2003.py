from math import sin, pi


class Solution:
    def f(self, x, b, c):
        return (x ** 2 + b * x + c)/sin(x)

    def solve(self, b, c):
        eps = 10 ** -9
        l, r = eps, (pi / 2) - eps
        while r - l > eps:
            m1 = l + (r - l) / 3
            m2 = r - (r - l) / 3
            if self.f(m1, b, c) > self.f(m2, b, c):
                l = m1
            else:
                r = m2

        print(f'{self.f(l, b, c):.10f}')


sol = Solution()
for _ in range(int(input())):
    b, c = [float(x) for x in input().split()]
    sol.solve(b, c)
