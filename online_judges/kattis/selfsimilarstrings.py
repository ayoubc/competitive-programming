import fileinput


class Solution:

    def solve(self, s):
        for d in range(len(s)-1, 0, -1):
            mp = {}
            for i in range(len(s) - d + 1):
                S = s[i:i+d]
                mp[S] = mp.get(S, 0) + 1
            ok = True
            for value in mp.values():
                if value < 2:
                    ok = False
                    break

            if ok:
                return d

        return 0


sol = Solution()
for line in fileinput.input():
    line = line.strip('\n')
    if line == '':
        break

    print(sol.solve(line))
