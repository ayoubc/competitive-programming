class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        l, r = 0, n-1
        OO = 10 ** 10
        while l <= r:
            mid = l + (r - l) // 2 
            if mid + 1 >= n:
                b = -OO
            else:
                b = nums[mid + 1]
            if mid - 1 < 0:
                a = -OO
            else:
                a = nums[mid - 1]
            
            if a < nums[mid] and b < nums[mid]:
                return mid
            
            elif b >= nums[mid] and a >= nums[mid]:
                if a > b:
                    r = mid - 1
                else:
                    l = mid + 1
            elif b >= nums[mid]:
                l = mid + 1
            else:
                r = mid - 1
