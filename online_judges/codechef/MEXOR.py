
class Solution:

    def solve(self, x):
        k = 0
        ans = 0
        while True:
            p = (1 << k)
            if p - 1 <= x:
                ans = p
            else:
                break
            
            k += 1
        return ans

sol = Solution()
for _ in range(int(input())):
    print(sol.solve(int(input())))
