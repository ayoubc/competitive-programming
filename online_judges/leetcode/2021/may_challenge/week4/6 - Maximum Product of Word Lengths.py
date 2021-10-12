from collections import defaultdict


class Solution:
    def maxProduct(self, words: List[str]) -> int:
        d = defaultdict(dict)
        for word in words:
            for letter in word:
                d[word][letter] = d[word].get(letter, 0) + 1
            
        ans = 0
        n = len(words)
        for i in range(n):
            for j in range(i+1, n):
                ok = True
                for key in d[words[j]].keys():
                    if d[words[i]].get(key, 0) > 0:
                        ok = False
                        break
                
                if ok:
                    ans = max(ans, len(words[i]) * len(words[j]))
        
        return ans