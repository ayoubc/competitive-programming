class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        d = {}
        for e in arr:
            d[e] = d.get(e, 0) + 1
        
        l = sorted(d.items(), reverse=True, key=lambda t: t[1])
        ans = 0
        cnt = 0
        n= len(arr)
        for e in l:
            if cnt * 2 < n:
                cnt += e[1]
                ans += 1
            else:
                break
        return ans