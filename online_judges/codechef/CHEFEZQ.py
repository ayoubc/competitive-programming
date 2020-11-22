import io


class Solution:
    def __int__(self):
        pass

    def solve(self, n, k, q):
        extra = 0
        for i in range(n):
            if extra + q[i] < k:
                return i+1
            extra = max(0, extra + q[i] - k)

        return n + extra // k + 1


sol = Solution()
t = int(input())
out = io.StringIO()
for i in range(t):
    n, k = map(int, input().split())
    q_list = list(map(int, input().split()))
    out.write(str(sol.solve(n, k, q_list)) + '\n')
print(out.getvalue())
