import io
from sys import stdin, stdout


class Solution:

    def solve(self, text):
        ans = 0
        stack = []
        for i in range(len(text)):
            c = text[i]
            if c == '<':
                stack.append(c)

            else:
                if len(stack) > 0:
                    if stack[-1] == '<':
                        stack.pop()
                        if len(stack) == 0:
                            ans = i + 1
                    else:
                        stack.append(c)
                else:
                    stack.append(c)
        if len(stack) == 0:
            ans = len(text)
        return ans


sol = Solution()
out = io.StringIO()
t = int(input())
for _ in range(t):
    text = input()
    ans = sol.solve(text)
    out.write(f'{ans}\n')

print(out.getvalue())
