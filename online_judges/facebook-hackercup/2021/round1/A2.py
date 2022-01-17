from sys import stdin, stdout
from collections import deque

filename = 'A2_big'
stdin = open(f'{filename}.txt', 'r')
stdout = open(f'{filename}_out.txt', 'w')



class Solution:
    
    def solve(self, s):
        o = s.find('O')
        x = s.find('X')
        o = o if o != -1 else len(s)
        x = x if x != -1 else len(s)
        if x == len(s) and o == len(s):
            return 0

        start = min(o, x)
        hand = 'r' if o < x else 'l'
        cnt = 0
        f_ends = 0
        d = {0: (start+1, 0)}
        for i in range(start+1, len(s)):
            new = False
            if s[i] == 'O' and hand == 'l':
                hand = 'r'
                new = True

            elif s[i] == 'X' and hand == 'r':
                hand = 'l'
                new = True

            else:
                if s[i] == 'F':
                    f_ends += 1
                else:
                    f_ends = 0

            if new:
                tmp = d[cnt] 
                d[cnt] = (tmp[0], f_ends)
                f_ends = 0
                cnt += 1
                d[cnt] = (1, 0)
            else:
                tmp = d[cnt] 
                d[cnt] = (tmp[0]+1, 0)

        ans = 0
        mod = 1000000007
        #print(d)
        sws = sorted(d.keys())
        m = len(sws)
        
        s1 = d[sws[0]][0]
        s2 = sws[0] * d[sws[0]][0]
        s3 = d[sws[0]][1]
        
        for i in range(1, m):
            t1 = sws[i]
            t2 = d[t1][0]
            t3 = d[t1][1]
            ans += t2 * (t1 * s1 - s2 - s3)
            ans %= mod
            s1 += t2
            s2 += t1 * t2
            s3 += t3
        #for i in range(m):
         #   for j in range(i+1, m):
          #      diff = sws[i] - sws[j]
           #     t1 = d[sws[j]][0]
            #    t2 = d[sws[i]][0]
             #   fs = d[sws[j]][1]
              #  ans += diff * t1 * t2 - fs * t2
               # ans %= mod
        return ans

sol = Solution()

t = int(stdin.readline())

for i in range(t):
    n = stdin.readline().strip('\n')
    s = stdin.readline().strip('\n')
    out = sol.solve(s)
    stdout.write(f'Case #{i+1}: {out}\n')

stdout.close()
