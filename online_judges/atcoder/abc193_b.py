import io
import time


def timer(func):
    def wrapper(self, *args):
        start = time.perf_counter()
        result = func(self, *args)
        end = time.perf_counter()
        print(f'Execution time: {(end - start):.2f} s')
        return result

    return wrapper


class Solution:

    # @timer
    def solve(self, n, shops):
        shops.sort()
        ans = -1
        for i in range(n):
            a, p, x = shops[i]
            if (a + 1) // 2 < x:
                if ans == -1:
                    ans = p
                else:
                    ans = min(ans, p)
        return ans


sol = Solution()
out = io.StringIO()
N = int(input())
shops = []
for _ in range(N):
    A, P, X = map(int, input().split())
    shops.append((2 * A, P, X))

print(sol.solve(N, shops))
# # print(out.getvalue())
