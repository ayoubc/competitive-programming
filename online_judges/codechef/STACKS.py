from io import StringIO


class Solution:
    def bs(self, x, arr):
        l, r = 0, len(arr) - 1
        ans = -1
        while l <= r:
            mid = l + (r - l) // 2
            if arr[mid] > x:
                ans = mid
                r = mid - 1
            else:
                l = mid + 1

        return ans

    def solve(self, n, a):
        ans = []
        for x in a:
            index = self.bs(x, ans)
            if index == -1:
                ans.append(x)
            else:
                ans[index] = x

        return f'{len(ans)} ' + ' '.join(map(str, ans))


out = StringIO()
sol = Solution()
for _ in range(int(input())):
    n = int(input())
    a = [int(x) for x in input().split()]
    out.write(f'{sol.solve(n, a)}\n')
print(out.getvalue())
