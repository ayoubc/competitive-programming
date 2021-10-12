from collections import deque, defaultdict


class Solution:
    def solve(self, n, a):
        d = defaultdict(list)
        q = deque()
        for i in range(n):
            q.append(([i+1], a[i] % 200))
            d[a[i] % 200].append([i+1])

        ans = None
        while len(q) > 0:
            found = False
            for val in d.values():
                if len(val) >= 2:
                    found = True
                    ans = val
                    break

            if found:
                break

            l, s = q.popleft()
            for i in range(l[-1], n):
                c = l.copy()
                c.append(i+1)
                q.append((c, (s + a[i]) % 200))
                d[(s + a[i]) % 200].append(c)

        if ans is None:
            print("No")

        else:
            l1, l2, *_ = ans
            print("Yes")
            print(len(l1), *l1)
            print(len(l2), *l2)


sol = Solution()
n = int(input())
a = [int(_) for _ in input().split()]
sol.solve(n, a)
