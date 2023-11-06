class Solution:
    def toLowerCase(self, s: str) -> str:
        res = ''
        for e in s:
            if 'A' <= e <= 'Z':
                res += chr(ord(e) - ord('A') + ord('a'))
            else:
                res += e
        
        return res