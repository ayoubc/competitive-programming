import io

class Solution:
    CONVERGENCE = 0.6321205588285578
    def solve(self, n):
        if n >= 1000:
            return self.CONVERGENCE

        ans = 1
        cur_fact = 1
        for k in range(1, n):
            cur_fact *= (k+1)
            p = -1
            if k % 2 == 0:
                p = 1
            ans += p / cur_fact

        return ans


# out = io.StringIO()
n = int(input())
sol = Solution()

print(sol.solve(n))
# print(out.getvalue())
