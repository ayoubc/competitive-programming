class Solution:
    def valid(self, part, direction='left'):
        if direction == 'left':
            return len(part) == 1 or (len(part) > 1 and part[0] != '0')

        else:
            return part[-1] != '0'

    def possible(self, part):
        n = len(part)
        res = []
        if str(int(part)) == part:
            res.append(part)

        for i in range(n-1):
            left = part[:i+1]
            right = part[i+1:]
            if not (self.valid(right, 'right') and self.valid(left)):
                continue

            x = f'{left}.{right}'
            res.append(x)

        return res
    
    def ambiguousCoordinates(self, s: str) -> List[str]:
        s = s.strip('()')
        n = len(s)
        ans = []
        for i in range(n-1):
            left = s[:i+1]
            right = s[i+1:]
            pl = self.possible(left)
            pr = self.possible(right)
            for a in pl:
                for b in pr:
                    ans.append(f'({a}, {b})')

        return ans