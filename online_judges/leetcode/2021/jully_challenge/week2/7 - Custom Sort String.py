class Solution:
    def customSortString(self, order: str, str: str) -> str:
        def sort(c):
            p = order.find(c)
            if p == -1:
                return 1000
            return p
        
        return ''.join(sorted(str, key=sort))
