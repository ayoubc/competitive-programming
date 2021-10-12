class Solution:
    def isNumber(self, s: str) -> bool:
        s = s.lower()
        
        x = s.split('e')
        if len(x) > 2:
            return False
        
        if len(x) == 2:
            try:
                int(x[-1])
            
            except:
                return False
        
        s = x[0]
        
        if len(s) >= 1 and s[0] == '+':
            s = s.lstrip('+')
        
        elif len(s) >= 1 and s[0] == '-':
            s = s.lstrip('-')
        
        if len(s) == 0:
            return False
        
        for i in range(26):
            if chr(ord('a') + i) in s:
                return False
        try:
            float(s)
        except:
            return False
        
        else:
            return True
                