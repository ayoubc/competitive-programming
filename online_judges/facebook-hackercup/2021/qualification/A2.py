from sys import stdin, stdout
from collections import deque

filename = 'A2_big'
stdin = open(f'{filename}.txt', 'r')
stdout = open(f'{filename}_out.txt', 'w')


def get_index(c):
    return ord(c) - ord('A')


class Solution:
    INF = 10 ** 9
    def solve(self, s, replaces):
        ans = self.INF
        n = len(s)

        def check(start, target):
            res = None
            visited = {start}
            q = deque()
            q.append((start, 0))

            while len(q) > 0:
                c, dist = q.popleft()
                if c == target:
                    res = dist
                    break

                index = get_index(c)
                for e in replaces[index]:
                    if e not in visited:
                        visited.add(e)
                        q.append((e, dist+1))

            if res is None:
                res = -1
            return res

        dists = [[self.INF] * 26 for i in range(26)]
        for i in range(26):
            tmp = 0
            c = chr(ord('A') + i)
            ok = True
            for j in range(n):
                if c == s[j]:
                    continue

                steps = dists[get_index(s[j])][i]
                if steps == self.INF:
                    steps = check(s[j], c)

                dists[get_index(s[j])][i] = steps
                if steps == -1:
                    ok = False
                    break

                tmp += steps
            if ok:
                ans = min(ans, tmp)

        if ans == self.INF:
            ans = -1
        return ans


sol = Solution()

t = int(stdin.readline())

for i in range(t):
    s = stdin.readline().strip('\n')
    k = int(stdin.readline())
    r = [[] for i in range(26)]
    for j in range(k):
        ab = stdin.readline().strip('\n')
        r[get_index(ab[0])].append(ab[1])

    out = sol.solve(s, r)
    stdout.write(f'Case #{i+1}: {out}\n')

stdout.close()
