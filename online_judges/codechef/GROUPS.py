import io


class Solution:

    def solve(self, s):
        cnt = 0
        i = 0
        n = len(s)
        while i < n:
            if s[i] == '0':
                i += 1
                continue

            cnt += 1
            j = i
            while j < n and s[j] == '1':
                j += 1

            i = j

        return cnt


out = io.StringIO()
sol = Solution()
t = int(input())
for _ in range(t):
    s = input()
    ans = sol.solve(s)
    out.write(f'{ans}\n')

print(out.getvalue())
