import io


class Solution:

    def solve(self, k, n):
        ans = list(range(1, n+1))
        for i in range(n):
            if i % 2 != 1:
                ans[i] *= -1

        pre = [0 for i in range(n)]
        pre[0] = ans[0]
        for i in range(1, n):
            pre[i] += ans[i] + pre[i - 1]
        cnt = n // 2
        for i in range(n-1, -1, -1):
            if cnt == k:
                break
            elif cnt > k:
                if pre[i] > 0 and ans[i] > 0:
                    ans[i] *= -1
                    cnt -= 1
            else:
                if pre[i] <= 0 and ans[i] < 0:
                    ans[i] *= -1
                    cnt += 1
        return ans


out = io.StringIO()
t = int(input())
sol = Solution()
for tc in range(t):
    n, k = map(int, input().split())
    ans = " ".join(list(map(str, sol.solve(k, n))))
    out.write(f'{ans}\n')

print(out.getvalue())
