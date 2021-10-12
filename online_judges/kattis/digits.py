class Solution:

    def solve(self, x):
        l = len(x)
        if l >= 10:
            return 4

        elif l > 1:
            return 3
        elif x == '1':
            return 1
        else:
            return 2


sol = Solution()
while True:
    x = input()
    if x == 'END':
        break

    print(sol.solve(x))
