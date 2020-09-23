# from sys import stdin, stdout
# stdin = open('in.txt', 'r')
# stdout = open('perimetric_chapter_1_output.txt', 'w')


class Solution:
    def __init__(self):
        self.mod = 1000000007

    def power(self, x, n):
        if n == 0:
            return 1
        b = self.power(x, n // 2)
        b = ((b % self.mod) * (b % self.mod)) % self.mod
        if n % 2 != 0:
            b = ((b % self.mod) * (x % self.mod)) % self.mod
        return b

    def solve(self, n):
        return (8 * self.power(9, n - 1)) % self.mod


out = Solution()
t = int(input())

for i in range(t):
    n = int(input())
    ans = out.solve(n)
    print(ans)
