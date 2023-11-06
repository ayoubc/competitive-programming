class Solution:
    def ispalindrome(self, x):
        tmp = str(x)
        return tmp[::-1] == tmp
    
    def superpalindromesInRange(self, left: str, right: str) -> int:
        s = set()
        limit = 10 ** 5
        for i in range(limit):
            tmp = str(i)
            x1, x2 = tmp + tmp[:-1][::-1], tmp + tmp[::-1]

            x1 = int(x1)
            x2 = int(x2)
            x1 = x1 ** 2
            x2 = x2 ** 2
            if self.ispalindrome(x1):
                s.add(x1)
            if self.ispalindrome(x2):
                s.add(x2)

        l = list(s)
        l.sort()
        
        left = int(left)
        right = int(right)
        
        ans = 0
        for x in l:
            if left <= x <= right:
                ans += 1
        return ans