import io


class Solution:

    def solve(self, n, c):
        l = list(range(1, n+1))
        cost = 0
        for i in range(n-2, -1, -1):
            index = -1
            for j in range(n-1, i-1, -1):
                if cost + j + 1 <= c:
                    index = j
                    break

            if index == -1:
                return None

            rev = []
            for j in range(i, index+1):
                rev.append(l[j])

            rev.reverse()
            for j in range(i, index+1):
                l[j] = rev[j - i]

            cost += index - i + 1

        if cost == c:
            return l

        return None


out = io.StringIO()
t = int(input())
sol = Solution()
for i in range(1, t+1):
    n, c = [int(x) for x in input().split()]
    ans = sol.solve(n, c)
    if ans:
        out.write(f'Case #{i}: {" ".join(map(str, ans))}\n')
    else:
        out.write(f'Case #{i}: IMPOSSIBLE\n')

print(out.getvalue())
