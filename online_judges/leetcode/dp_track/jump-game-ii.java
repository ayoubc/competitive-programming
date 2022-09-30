class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int MAX = (int)1e9;

        dp[0] = 0;
        for(int i=1;i<n;i++) dp[i] = MAX;
        for(int i=0;i<n;i++) {
            for(int j=1;j<Math.min(n-i, nums[i]+1);j++) {
                dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
            }
        }
        return dp[n-1];
    }
}