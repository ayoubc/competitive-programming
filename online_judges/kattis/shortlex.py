class Solution:
    def solve(self, n):
        tot = 0
        l = 0
        while tot + (1 << l) <= n:
            tot += (1 << l)
            l += 1


        index = n - tot
        ans = bin(index)[2:]
        ans = "0" * (l - len(ans)) + ans
        return ans


sol = Solution()

for _ in range(int(input())):
    n = int(input())
    print(sol.solve(n))


