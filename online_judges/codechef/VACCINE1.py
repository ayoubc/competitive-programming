import io


class Solution:
    def solve(self, d_1, v_1, d_2, v_2, p):
        if d_1 == d_2 and d_1 == 1:
            tot = v_1 + v_2
            return (p + tot - 1) // tot
        ans = 0
        i = 0
        while ans < p:
            tmp = 0
            i += 1
            if i >= d_1:
                tmp += v_1
            if i >= d_2:
                tmp += v_2
            ans += tmp
        return i


out = io.StringIO()
d_1, v_1, d_2, v_2, p = map(int, input().split())
sol = Solution()
print(sol.solve(d_1, v_1, d_2, v_2, p))
