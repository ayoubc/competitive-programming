class Solution:
    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        ans = []
        for word in words:
            n = len(word)
            d = {}
            ok = True
            taken = set()
            for i in range(n):
                c = d.get(word[i], None)
                if c is None:
                    if pattern[i] in taken:
                        ok = False
                        break
                    d[word[i]] = pattern[i]
                    taken.add(pattern[i])
                    
                elif c != pattern[i]:
                    ok = False
                    break
            
            if ok:
                ans.append(word)
        
        return ans