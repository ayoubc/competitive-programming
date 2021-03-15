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

    def score(self, cards):
        occ = [0] * 10
        for i in range(4):
            occ[int(cards[i])] += 1
        res = [0] * 10
        for i in range(1, 10, 1):
            res[i] = i * 10 ** occ[i]

        return res
    # @timer

    def solve(self, k, s, t):
        occ = [k] * 10
        for i in range(4):
            occ[int(s[i])] -= 1
            occ[int(t[i])] -= 1

        s_score = self.score(s)
        t_score = self.score(t)

        wins = 0
        tot = 0
        for i in range(1, 10, 1):
            if occ[i] == 0:
                continue

            tmps = sum(s_score) + s_score[i] * 9
            for j in range(1, 10, 1):
                if i == j and occ[i] < 2 or (occ[j] == 0):
                    continue

                tmpt = sum(t_score) + t_score[j] * 9
                tot += occ[i] * (occ[j] if i !=j else occ[i] - 1)
                if tmps > tmpt:
                    wins += occ[i] * (occ[j] if i !=j else occ[i] - 1)

        return wins / tot


sol = Solution()
out = io.StringIO()
K = int(input())
S = input()
T = input()
print(sol.solve(K, S, T))
# # print(out.getvalue())
