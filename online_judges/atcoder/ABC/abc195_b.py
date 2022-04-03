import io


class Solution:

    def solve(self, a, b, w):
        w *= 1000
        m = None
        M = None
        for i in range(1, w + 1):
            y = w / i
            if a <= y <= b:
                if m is None:
                    m = i
                if M is None:
                    M = i
                if m is not None:
                    m = min(m, i)
                if M is not None:
                    M = max(M, i)

        if m is None or M is None:
            return 'UNSATISFIABLE'

        return f'{m} {M}'


out = io.StringIO()
sol = Solution()

A, B, W = [int(x) for x in input().split()]
print(sol.solve(A, B, W))
