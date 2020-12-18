import io
import math
from collections import deque
# import fileinput
# for line in fileinput.input()
MAX = 100000

class Solution:
    def is_digit(self, d):
        return ord('0') <= ord(d) <= ord('9')

    def to_int(self, str_):
        return 1 if str_ == '' else int(str_)

    def get_occ(self, str_):
        occ = {}
        i = 0
        while i < len(str_):
            cur_num = ''
            j = i+1
            while j < len(str_) and self.is_digit(str_[j]):
                cur_num += str_[j]
                j += 1

            occ[str_[i]] = occ.get(str_[i], 0) + self.to_int(cur_num)
            i = j

        return occ

    def solve(self, src, n, dist):
        occ_src = self.get_occ(src)
        occ_dist = self.get_occ(dist)
        ans = None
        for key in occ_dist:
            if ans is None:
                ans = (n * occ_src.get(key, 0)) // occ_dist[key]
            else:
                ans = min(ans, (n * occ_src.get(key, 0)) // occ_dist[key])
        return ans


# out = io.StringIO()
src, n = map(str, input().split())
dist = input()
sol = Solution()
print(sol.solve(src, int(n), dist))
