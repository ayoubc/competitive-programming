import io


class Solution:
    valid = '0123456789ACDEFHJKLMNPRTVWX'
    confusing = {'B': '8', 'G': 'C', 'I': '1', 'O': '0', 'Q': '0', 'S': '5', 'U': 'V', 'Y': 'V', 'Z': '2'}
    a = [2, 4, 5, 7, 8, 10, 11, 13]

    def get_value(self, check):
        val = 0
        n = 7
        dec = 0
        for i in range(8):
            c = check[i]
            if check[i] in self.confusing:
                c = self.confusing[check[i]]
            index = self.valid.find(c)
            val += index * self.a[i]
            dec += index * 27 ** (n - i)
        return val % 27, dec

    def solve(self, ucn):
        values = self.get_value(ucn[:8])
        if self.valid[values[0]] == ucn[-1]:
            return values[1]
        return "invalid"


out = io.StringIO()
t = int(input())
sol = Solution()
for _ in range(t):
    k, ucn = input().split()
    out.write(f'{k} {sol.solve(ucn)}\n')

print(out.getvalue())