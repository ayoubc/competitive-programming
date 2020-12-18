import io


def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a%b)


class Solution:
    def __init__(self, a, n):
        gcd_left = list(range(n))
        gcd_right = list(range(n))
        gcd_left[0], gcd_right[n - 1] = a[0], a[n - 1]
        for i in range(1, n):
            gcd_left[i] = gcd(gcd_left[i - 1], a[i])
        for i in range(n - 2, -1, -1):
            gcd_right[i] = gcd(gcd_right[i + 1], a[i])

        self.gcd_left = gcd_left
        self.gcd_right = gcd_right

    def solve(self, l, r):
        if l == 0:
            return self.gcd_right[r+1]
        if r == n-1:
            return self.gcd_left[l-1]
        return gcd(self.gcd_left[l-1], self.gcd_right[r+1])


out = io.StringIO()
t = int(input())

for tc in range(t):
    n, q = map(int, input().split())
    a = list(map(int, input().split()))
    sol = Solution(a, n)
    for i in range(q):
        l, r = map(int, input().split())
        l -= 1
        r -= 1
        out.write(str(sol.solve(l, r)) + '\n')

print(out.getvalue())
