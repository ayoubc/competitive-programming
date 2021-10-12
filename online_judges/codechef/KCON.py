from io import StringIO


class Solution:

    def solve(self, n, k, a):
        best_sum = None
        current_sum = 0
        for x in a:
            current_sum = max(x, current_sum + x)
            if best_sum is None:
                best_sum = current_sum
            else:
                best_sum = max(best_sum, current_sum)

        best_prefix = a[0]
        current_sum = a[0]
        for i in range(1, n):
            current_sum += a[i]
            best_prefix = max(current_sum, best_prefix)

        best_suffix = a[n-1]
        current_sum = a[n-1]
        for i in range(n-2, -1, -1):
            current_sum += a[i]
            best_suffix = max(best_suffix, current_sum)

        # print(best_sum, best_suffix, best_prefix)
        if k == 1:
            return best_sum

        s = sum(a)
        return max(best_sum, (k-2) * s + best_suffix + best_prefix, best_prefix + best_suffix)


sol = Solution()
out = StringIO()
for _ in range(int(input())):
    n, k = [int(_) for _ in input().split()]
    a = [int(_) for _ in input().split()]
    out.write(f'{sol.solve(n, k, a)}\n')

print(out.getvalue())
