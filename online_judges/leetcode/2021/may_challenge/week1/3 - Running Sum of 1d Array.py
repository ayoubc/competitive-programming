class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        n = len(nums)
        prev = [0] * n
        
        for i in range(n):
            if i == 0:
                prev[i] = nums[i]
            else:
                prev[i] = nums[i] + prev[i - 1]
        
        return prev