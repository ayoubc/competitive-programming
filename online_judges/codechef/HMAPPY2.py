
def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)


def lcm(a, b):
    return a * (b // gcd(a, b))


class Solution:
    def solve(self, n, a, b, k):
        ans = n // b + n // a - 2 * (n // lcm(a, b))
        print('Win' if ans >= k else 'Lose')


sol = Solution()
for _ in range(int(input())):
    n, a, b, k = [int(x) for x in input().split()]
    sol.solve(n, a, b, k)
