import io
from sys import stdin, stdout


class Solution:

    def solve(self, text):
        depth = 0
        first_max_depth = 0
        max_symbols = 0
        first_max_symbols = 0
        stack = []
        for i in range(len(text)):
            c = text[i]
            if c == '1':
                stack.append((c, i))

            else:
                if len(stack) > depth:
                    depth = len(stack)
                    first_max_depth = i

                bracket = stack.pop()
                if i - bracket[1] + 1 > max_symbols:
                    max_symbols = i - bracket[1] + 1
                    first_max_symbols = bracket[1] + 1

        return depth, first_max_depth, max_symbols, first_max_symbols


sol = Solution()
out = io.StringIO()
n = int(input())
text = input().split()
ans = sol.solve(text)
ans = " ".join(map(str, ans))
out.write(f'{ans}\n')

print(out.getvalue())
