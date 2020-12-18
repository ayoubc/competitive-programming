import io
# import fileinput
# for line in fileinput.input()


class Solution:
    def __init__(self, a):
        self.a = a

    def ok(self, h):
        res = 0
        for val in self.a:
            if val >= h:
                res += 1
        return res >= h

    def solve(self):
        l, r = 1, 10**9
        ans = 0
        while l <= r:
            mid = (l + r) // 2
            if self.ok(mid):
                ans = mid
                l = mid+1
            else:
                r = mid-1
        return ans


# out = io.StringIO()
t = int(input())
a = []
for tc in range(t):
    a.append(int(input()))
sol = Solution(a)
print(sol.solve())