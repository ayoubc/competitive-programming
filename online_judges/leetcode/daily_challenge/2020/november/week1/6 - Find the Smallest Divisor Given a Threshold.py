class Solution:
    def smallestDivisor(self, nums: List[int], threshold: int) -> int:

        ans = 1
        l, r = 1, 10 ** 6
        while l <= r:
            mid = (r + l) // 2
            if self.ok(mid, nums, threshold):
                r = mid - 1
                ans = mid
            else:
                l = mid + 1

        return ans

    def ok(self, divisor, nums, threshold):
        s = 0
        for ele in nums:
            s += (ele + divisor - 1) // divisor

        return s <= threshold
