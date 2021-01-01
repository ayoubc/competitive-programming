import io


def phi(n):
    ans = n
    i = 2
    while i * i <= n:
        if n % i == 0:
            while n % i == 0:
                n //= i
            ans -= ans // i
        i += 1
    if n > 1:
        ans -= ans // n
    return ans


class Solution:

    def solve(self, n):
        return phi(n)


#out = io.StringIO()
sol = Solution()
t = int(input())
for _ in range(t):
    n = int(input())
    print(sol.solve(n))
    #out.write(f'{sol.solve(n)}\n')

#print(out.getvalue())
