class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        d = {}
        n = len(t)
        mapped = set()
        for i in range(n):
            e = s[i]
            c = d.get(e)
            if c is None:
                if t[i] in mapped:
                    return False
                else:
                    d[e] = t[i]
                    mapped.add(t[i])
            elif c != t[i]:
                return False
        return True