class Solution:
    def isPalindrome(self, s):
        n = len(s)
        for i in range(n//2):
            if s[i] != s[n-i-1]:
                return False
        return True
    
    def palindromePairs(self, words: List[str]) -> List[List[int]]:
        ans = set()
        n = len(words)
        d = {}
        palindrome = [False] * n
        for i in range(n):
            d[words[i]] = i
            palindrome[i] = self.isPalindrome(words[i])
            
        for i in range(n):
            m = len(words[i])
            word = words[i]
            if m == 0:
                for j in range(n):
                    if i == j:
                        continue
                    
                    if palindrome[j]:
                        ans.add((i, j))
                        ans.add((j, i))
                
                continue
            for j in range(m):
                s = ''
                for k in range(j, -1, -1):
                    s += word[k]
                
                index = d.get(s)
                if index is not None and index != i and self.isPalindrome(word+s):
                    ans.add((i, index))
            
            for j in range(m-1, -1, -1):
                s = ''
                for k in range(m-1, j-1, -1):
                    s += word[k]
                
                index = d.get(s)
                if index is not None and index != i and self.isPalindrome(s+word):
                    ans.add((index, i))
        return ans