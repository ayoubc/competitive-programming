import io


class Solution:
    def get_d(self, c):
        d = 0
        while (1 << d) <= c:
            d += 1
        return d

    def to_int(self, l):
        return int(''.join(l), 2)

    def solve(self, s):
        d = self.get_d(c)
        a = ['0'] * d
        b = ['0'] * d
        indices = []
        for i in range(d):
            if c & (1 << i) == 0:
                a[d-1-i] = '1'
                b[d-1-i] = '1'

            else:
                indices.append(d-1-i)

        indices.sort()
        n = len(indices)
        for i in range(0, n):
            if self.to_int(a) > self.to_int(b):
                b[indices[i]] = '1'
            else:
                a[indices[i]] = '1'

        return self.to_int(a) * self.to_int(b)


out = io.StringIO()
sol = Solution()
t = int(input())
for _ in range(t):
    c = int(input())
    ans = sol.solve(c)
    out.write(f'{ans}\n')

print(out.getvalue())
