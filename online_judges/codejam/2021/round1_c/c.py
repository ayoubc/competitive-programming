from io import StringIO
from collections import deque


class Solution:
    def bnot(self, x):
        b = list(bin(x)[2:])
        for i in range(len(b)):
            if b[i] == '1':
                b[i] = '0'
            else:
                b[i] = '1'
        return int(''.join(b), base=2)

    def solve(self, s, e):
        target = int(e, base=2)
        start = int(s, base=2)
        q = deque()
        limit = 16
        if start == target:
            return 0

        q.append((start, 0))
        st = set()
        while len(q) > 0:
            cur, steps = q.popleft()
            if cur == target:
                return steps

            # if cur in st:
            #     continue

            if steps > limit:
                continue

            x, y = 2 * cur, self.bnot(cur)
            q.append((x, steps+1))
            q.append((y, steps+1))
            # st.add(cur)

        return 'IMPOSSIBLE'


sol = Solution()
out = StringIO()
for i in range(int(input())):
    s, e = input().split()
    out.write(f'Case #{i+1}: {sol.solve(s, e)}\n')

print(out.getvalue())
