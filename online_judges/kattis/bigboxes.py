import io
from math import sqrt


class Solution:

    def __init__(self, n, k, w):
        self.n = n
        self.k = k
        self.w = w

    def ok(self, mid):
        bags = []
        cur_w = 0
        for i in range(self.n):
            if cur_w + self.w[i] <= mid:
                cur_w += self.w[i]
            else:
                bags.append(cur_w)
                cur_w = self.w[i]
        if cur_w > 0:
            bags.append(cur_w)

        return len(bags), max(bags)

    def solve(self):
        l, r = 1, 1000000000
        ans = r
        while l <= r:
            mid = l + (r - l) // 2
            bags, big = self.ok(mid)
            if bags == self.k:
                ans = min(ans, big)
                r = mid - 1

            elif bags < self.k:
                r = mid - 1
            else:
                l = mid + 1
        return ans


# out = io.StringIO()
n, k = map(int, input().split())
w = [int(x) for x in input().split()]
sol = Solution(n, k, w)
print(sol.solve())
