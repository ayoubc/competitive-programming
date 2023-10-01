class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[1001];
        for(int i=0;i<n;i++) dp[nums[i]] = 1;
        for(int t=0;t<=target;t++) {
            for(int i=0;i<n;i++) {
                if (t >= nums[i]) dp[t] += dp[t-nums[i]];
            }
        }
        return dp[target];
    }
}