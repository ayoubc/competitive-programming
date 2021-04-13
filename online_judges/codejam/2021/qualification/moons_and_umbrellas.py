import io
from itertools import permutations


class Solution:

    def solve(self, x, y, s):
        cost = {'CJ': x, 'JC': y, 'JJ': 0, 'CC': 0}
        S = list(s.strip('?'))
        ans = 0
        # i, j = 0, len(s) - 1
        # while s[i] == '?':
        #     i += 1
        #
        # while s[j] == '?':
        #     j -= 1
        #
        # if x < 0 and y < 0:
        #
        # elif x < 0:
        #
        # elif y < 0:
        #
        #
        #
        for i in range(len(S)-1):
            if S[i] == '?':
                if S[i+1] == '?':
                    S[i] = S[i-1]
                else:
                    if S[i+1] == S[i-1]:
                        S[i] = S[i-1]
                    else:
                        c1 = cost[S[i-1]+'C'] + cost['C' + S[i+1]]
                        c2 = cost[S[i-1]+'J'] + cost['J' + S[i+1]]
                        if c1 < c2:
                            ans += c1
                            S[i] = 'C'
                        else:
                            ans += c2
                            S[i] = 'J'
            else:
                if S[i+1] != '?':
                    ans += cost[S[i] + S[i + 1]]

        return ans


out = io.StringIO()
t = int(input())
sol = Solution()
for i in range(1, t+1):
    x, y, s = input().split()
    ans = sol.solve(int(x), int(y), s)
    out.write(f'Case #{i}: {ans}\n')

print(out.getvalue())
