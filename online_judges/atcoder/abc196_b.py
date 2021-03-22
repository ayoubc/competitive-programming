import io


class Solution:

    def solve(self, x):
        i = x.find('.')
        if i == -1:
            return x
        return x[:i]


out = io.StringIO()
sol = Solution()
x = input()
print(sol.solve(x))
