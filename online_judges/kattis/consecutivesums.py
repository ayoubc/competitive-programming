# from sys import stdin, stdout
# stdin = open('in.txt', 'r')
# stdout = open('perimetric_chapter_1_output.txt', 'w')
from math import sqrt, pow


class Solution:
    def __init__(self):
        pass

    def solve(self, n):
        a = -1
        end = int(sqrt(2 * n)) + 1
        for m in range(2, end+1):
            c = 2 * n - (m - 1) * m
            if c % (2 * m) == 0 and c > 0:
                a = c // (2 * m)
                b = a + m - 1
                break
        if a == -1:
            return 'IMPOSSIBLE'
        return f'{n} = ' + " + ".join(list(map(str, range(a, b+1))))


out = Solution()
t = int(input())

for i in range(t):
    n = int(input())
    ans = out.solve(n)
    print(ans)