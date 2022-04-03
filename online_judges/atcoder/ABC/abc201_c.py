

class Solution:

    def solve(self, s):
        ans = 0
        for i in range(10 ** 4):
            n = str(i)
            if len(n) < 4:
                n = '0' * (4 - len(n)) + n

            ok = True
            for j in range(10):
                if (s[j] == 'x' and str(j) in n) or (s[j] == 'o' and not (str(j) in n)) :
                    ok = False
                    break

            if ok:
                ans += 1
        return ans


sol = Solution()
s = input()
print(sol.solve(s))
