# https://www.geeksforgeeks.org/sum-products-possible-subsets/


class Solution:
    def solve(self, d):
        l = list(d.values())
        p = 1
        for v in l:
            p *= (1 + v)

        return p - 1
        


sol = Solution()
for _ in range(int(input())):
    n = int(input())
    d = {}
    for i in range(n):
        a, b = input().split()
        d[b] = d.get(b, 0) + 1

    print(sol.solve(d))
