import io
import itertools


class Solution:
    def __int__(self):
        pass

    def is_power_two(self, n):
        return n & (n - 1) == 0

    def solve(self, n):
        if n == 1:
            return ['1']
        if self.is_power_two(n):
            return ['-1']

        ans = [2, 3, 1]
        cur = 4
        while cur <= n:
            if self.is_power_two(cur):
                ans.extend([cur + 1, cur])
                cur += 2
            else:
                ans.append(cur)
                cur += 1
        return list(map(str, ans))


sol = Solution()
t = int(input())
out = io.StringIO()
for i in range(t):
    n = int(input())
    out.write(" ".join(sol.solve(n)) + '\n')
print(out.getvalue())
