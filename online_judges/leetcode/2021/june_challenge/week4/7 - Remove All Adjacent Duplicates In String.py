class Solution:
    def removeDuplicates(self, s: str) -> str:
        stack = []
        for e in s:
            if len(stack) == 0:
                stack.append(e)
            else:
                if stack[-1] == e:
                    stack.pop()
                else:
                    stack.append(e)
        
        return ''.join(stack)
    
            