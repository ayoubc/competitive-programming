class Solution:
    def checkPossibility(self, nums: List[int]) -> bool:
        cnt = 0
        n = len(nums)
        index = -1
        for i in range(1, n):
            if nums[i] < nums[i-1]:
                cnt += 1
                index = i
        
        if cnt >= 2:
            return False

        
        if 1 < index < n-1:
            l = [nums[index], nums[index-1]]
            for x in l:
                b = x <= nums[index+1]
                if index - 2 >= 0:
                    b = b and x >= nums[index-2]
                if b:
                    return True
            
            return False
        return True