from io import StringIO


class Solution:
    def isroaring(self, y):
        n = len(y)
        for p in range(1, n//2 + 1):
            cur = y[:p]
            index = p
            ok = True
            while index < n:
                s = str(int(cur)+1)
                new_index = y.find(s, index)
                if new_index != index:
                    ok = False
                    break

                cur = s
                index = index + len(s)

            if ok:
                return True
        return False

    def solve(self, y):
        l, r = y + 1, 10 ** 100
        ans = None
        while l <= r:
            mid = (l + r) // 2
            if self.isroaring(str(mid)):
                r = mid - 1
                ans = mid
            else:
                l = mid + 1
        return ans


sol = Solution()
out = StringIO()
for i in range(int(input())):
    out.write(f'Case #{i+1}: {sol.solve(int(input()))}\n')

print(out.getvalue())
