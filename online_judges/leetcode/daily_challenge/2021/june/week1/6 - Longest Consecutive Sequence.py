class Solution:
    
    def longestConsecutive(self, nums: List[int]) -> int:
        nums.sort()
        ans = 1
        cnt = 1
        n = len(nums)
        if n == 0:
            return 0
        for i in range(1, n):
            if nums[i] - nums[i-1] == 1:
                cnt += 1
            elif nums[i] - nums[i-1] > 1:
                ans = max(ans, cnt)
                cnt = 1
        ans = max(ans, cnt)
        return ans
                