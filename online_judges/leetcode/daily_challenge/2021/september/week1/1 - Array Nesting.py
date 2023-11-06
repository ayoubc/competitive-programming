class Solution:
    def arrayNesting(self, nums: List[int]) -> int:
        n = len(nums)
        vis = [False] * n
        def travers(start):
            cur = nums[start]
            cnt = 0
            while True:
                if vis[cur]:
                    break
                
                cnt += 1
                vis[cur] = True
                cur = nums[cur]
                
            return cnt
        
        ans = 0
        for i in range(n):
            if not vis[i]:
                ans = max(ans, travers(i))
       
        return ans