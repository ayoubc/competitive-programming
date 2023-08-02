class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int sum = 0;
        int n = nums.length;
        while (l < n && r < n) {
            while (sum < target && r < n) {
                sum += nums[r];
                r++;
            }
            while (sum >= target && l < n) {
                ans = Math.min(ans, r - l);
                sum -= nums[l];
                l++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}