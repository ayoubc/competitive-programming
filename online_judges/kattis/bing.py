import io


class Solution:

    def __init__(self):
        pass

    def solve(self, n):
        mp = dict()
        for i in range(n):
            s = input()
            print(mp.get(s, 0))
            for j in range(len(s)):
                substr = s[0:j + 1]
                mp[substr] = mp.get(substr, 0) + 1


out = io.StringIO()
sol = Solution()
n = int(input())
sol.solve(n)
