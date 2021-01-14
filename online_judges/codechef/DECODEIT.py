import io
from sys import stdin


class Solution:
    def __init__(self):
        self.d = {}
        for i in range(16):
            c = chr(i + ord('a'))
            self.d[self.get_encoding(c)[:4]] = c

    def get_encoding(self, c):
        arr = list(range(16))
        ord_ = ord(c) - ord('a')
        l, r = 0, 15
        ans = ''
        while l <= r:
            mid = l + (r - l) // 2
            if ord_ <= mid:
                ans += '0'
                r = mid - 1
            else:
                ans += '1'
                l = mid + 1

        return ans

    def solve(self, N, S):
        ans = ''
        for i in range(0, N, 4):
            ans += self.d[S[i:i+4]]
        return ans


out = io.StringIO()
sol = Solution()
t = int(input())
for _ in range(t):
    N = int(input())
    S = input()
    out.write(f'{sol.solve(N, S)}\n')

print(out.getvalue())
