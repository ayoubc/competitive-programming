
class Solution:

    def solve(self, n, d):
        def check(x):
            return str(d) in str(x)

        old = n
        d = str(d)
        while True:
            s = str(n)
            p = s[::-1].find(d)
            if p == -1:
                break

            left = s[len(s)-p:]
            if left == '':
                left = 0
            else:
                left = int(left)

            n += 10 ** p - left

        return n - old

sol = Solution()
for _ in range(int(input())):
    n, d = map(int, input().split())

    print(sol.solve(n, d))
