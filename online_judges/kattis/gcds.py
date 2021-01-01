import io
from math import sqrt
# import fileinput
# for line in fileinput.input()
from collections import defaultdict


def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)


class Solution:

    def solve(self, n, a):
        unique_a = []
        s = set()
        for ele in a:
            if ele not in s:
                unique_a.append(ele)
                s.add(ele)

        ans = set()
        for i in range(len(unique_a)):
            cur = unique_a[i]
            for j in range(i, len(unique_a)):
                cur = gcd(cur, unique_a[j])
                ans.add(cur)

        return len(ans)


sol = Solution()
n = int(input())
a = []
for _ in range(n):
    a.append(int(input()))

print(sol.solve(n, a))
