class Solution {
    private int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        int ans = 0;
        for(int i=0;i<n;i++) ans = Math.max(ans, solve(i, nums));
        return ans;
    }
    private int solve(int i, int[] nums) {
        if (i < 0) return 0;
        if (dp[i] != -1) return dp[i];
        int res = Math.max(nums[i]+solve(i-2, nums), solve(i-1, nums));
        return dp[i] = res;
    }
}