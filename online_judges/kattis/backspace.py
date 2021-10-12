class Solution:
    def solve(self, s):
        stack = []
        for e in s:
            if e == '<':
                stack.pop()
            else:
                stack.append(e)

        return ''.join(stack)


sol = Solution()

print(sol.solve(input()))
