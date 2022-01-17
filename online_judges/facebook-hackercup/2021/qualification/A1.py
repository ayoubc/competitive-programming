from sys import stdin, stdout
# filename = 'big'
# stdin = open(f'{filename}.txt', 'r')
# stdout = open(f'{filename}_out.txt', 'w')


class Solution:
    def solve(self, s):
        ans = 10 ** 9
        n = len(s)
        vowel = {"A", "E", "I", "O", "U"}
        for i in range(26):
            tmp = 0
            c = chr(ord('A') + i)
            for j in range(n):
                if c == s[j]:
                    continue

                if c in vowel:
                    tmp += 2 if s[j] in vowel else 1
                else:
                    tmp += 1 if s[j] in vowel else 2
            ans = min(ans, tmp)
        return ans


sol = Solution()

t = int(stdin.readline())

for k in range(t):
    s = stdin.readline().strip('\n')
    out = sol.solve(s)
    stdout.write(f'Case #{k+1}: {out}\n')
    # stdout.write('\n'.join(out) + '\n')

# stdout.close()
