import io
import time
from math import log, sqrt


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
    def solve(self, n):
        a = 2
        s = set()
        while True:
            p = a ** 2
            if p > n:
                break

            while p <= n:
                s.add(p)
                p *= a
            a += 1
        return n - len(s)


sol = Solution()
out = io.StringIO()
N = int(input())
print(sol.solve(N))
# # print(out.getvalue())