class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)

        OO = 10 ** 7
        dp = [OO for i in range(n)]
        dp[0] = 0
        for i in range(n):
            for j in range(1, min(n - i, nums[i] + 1)):
                dp[i + j] = min(dp[i + j], dp[i] + 1)
        
        return dp[n-1]