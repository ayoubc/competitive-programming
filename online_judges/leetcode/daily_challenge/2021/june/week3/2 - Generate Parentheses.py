from itertools import permutations 
class Solution:
    
    def generateParenthesis(self, n: int) -> List[str]:
        def is_balanced(s):
            stack = []
            for e in s:
                if e == '(' or len(stack) == 0:
                    stack.append(e)
                else:
                    if stack[-1] == '(':
                        stack.pop()
                    else:
                        stack.append(e)
            return len(stack) == 0
        
        
        ans = []
        n *= 2
        for b in range(1<<n):
            l = [')'] * n
            for j in range(n):
                if (1 << j) & b:
                    l[j] = '('
            s = ''.join(l)
            if is_balanced(s):
                ans.append(s)
        return ans