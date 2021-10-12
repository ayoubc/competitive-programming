from io import StringIO


class Solution:
    def solve(self, n, k, p):
        ans = 0
        for a in range(1, k+1):
            for b in range(1, k+1):
                cnt = 0
                for c in range(1, k+1):
                    ok = True
                    for i in range(n):
                        if abs(a-c) >= abs(p[i] - c) and abs(b-c) >= abs(p[i] - c):
                            ok = False
                            break

                    if ok:
                        cnt += 1
                # if ans < cnt:
                #     print(a, b)
                ans = max(ans, cnt)

        return ans / k


sol = Solution()
out = StringIO()
for i in range(int(input())):
    n, k = [int(y) for y in input().split()]
    p = [int(y) for y in input().split()]
    out.write(f'Case #{i+1}: {sol.solve(n, k, p)}\n')

print(out.getvalue())
