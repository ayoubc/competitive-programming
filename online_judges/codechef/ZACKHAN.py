from math import sqrt


class Solution:
    def is_perfect(self, s):
        return int(sqrt(s))

    def solve(self, l, b):
        x = l * b
        q = int(sqrt(x))
        ans = 0
        divs = []
        for i in range(1, q):
            if x % i == 0:
                divs.append(i)
                if i != x // i:
                    divs.append(x // i)

        for s in divs:
            if x % (s * s) == 0 and (l // s) * (b // s) == x // (s * s) :
                ans = max(s, ans)

        print(ans)


sol = Solution()
for _ in range(int(input())):
    l, b = [int(x) for x in input().split()]
    sol.solve(l, b)
