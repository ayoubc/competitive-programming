import io


class Solution:
    players = ['First', 'Second']

    def brute_force(self, n, a):
        occ = [0] * (n+1)
        b = a.copy()
        b.sort()
        for i in range(n):
            if i + 1 < b[i]:
                return 'Second'
            occ[b[i]] += 1

        turn = 0
        while True:
            max_occ, index = 0, -1
            for i in range(1, n+1):
                if max_occ < occ[i]:
                    max_occ, index = occ[i], i

            if max_occ == 1:
                break

            turn = 1 - turn
            occ[index] -= 1
            occ[index+1] += 1

        return self.players[1 - turn]

    def solve(self, n, a):
        a.sort()
        cnt = 0
        for i in range(n):
            if i + 1 < a[i]:
                return 'Second'

            cnt += i + 1 - a[i]

        return self.players[1 - cnt % 2]


out = io.StringIO()
sol = Solution()
t = int(input())
for _ in range(t):
    n = int(input())
    a = [int(x) for x in input().split()]
    ans = sol.solve(n, a)
    out.write(f'{ans}\n')

print(out.getvalue())
