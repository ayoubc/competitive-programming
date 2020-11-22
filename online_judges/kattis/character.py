import io


class Solution:

    def __init__(self):
        pass

    def solve(self, n):
        return 2 ** n - (n + 1)


out = io.StringIO()
sol = Solution()
n = int(input())
print(sol.solve(n))

