from sys import stdin, stdout
from collections import deque

filename = 'A1_big'
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
        ans = 0
        for i in range(start+1, len(s)):
            if s[i] == 'O' and hand == 'l':
                hand = 'r'
                ans += 1
            if s[i] == 'X' and hand == 'r':
                hand = 'l'
                ans += 1
        return ans

sol = Solution()

t = int(stdin.readline())

for i in range(t):
    n = stdin.readline().strip('\n')
    s = stdin.readline().strip('\n')
    out = sol.solve(s)
    stdout.write(f'Case #{i+1}: {out}\n')

stdout.close()
