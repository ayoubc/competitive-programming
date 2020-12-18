import io


def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a%b)


class Solution:

    def solve(self, n, a):
        if n == 1:
            return a[0] + 1
        ans = 0
        gcd_left = list(range(n))
        gcd_right = list(range(n))
        gcd_left[0], gcd_right[n-1] = a[0], a[n-1]
        for i in range(1, n):
            gcd_left[i] = gcd(gcd_left[i-1], a[i])
        for i in range(n-2, -1, -1):
            gcd_right[i] = gcd(gcd_right[i+1], a[i])

        for i in range(n):
            if i == 0:
                d = gcd_right[1]
            elif i == n-1:
                d = gcd_left[n-2]
            else:
                d = gcd(gcd_left[i-1], gcd_right[i+1])
            if a[i] % d != 0:
                ans = d
                break
        return ans


out = io.StringIO()
n = int(input())
a = list(map(int, input().split()))
sol = Solution()
print(sol.solve(n, a))
