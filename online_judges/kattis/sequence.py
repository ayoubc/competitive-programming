# from sys import stdin, stdout
# stdin = open('in.txt', 'r')
# stdout = open('perimetric_chapter_1_output.txt', 'w')


class Solution:
    def __init__(self):
        pass

    def solve(self, n):
        cur = 1
        ans = []
        while cur <= n:
            ans.append(cur)
            cur *= 2

        return ans


out = Solution()
n = int(input())
ans = out.solve(n)
print(len(ans))
print(*ans)
