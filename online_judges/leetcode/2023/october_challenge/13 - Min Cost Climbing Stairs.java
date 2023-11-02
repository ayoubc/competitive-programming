class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length + 1;
        int[] dp = new int[n];
        for(int i=0;i<n;i++) dp[i] = -1;
        dp[0] = cost[0];
        for(int i=1;i<n;i++) {
            int res = dp[i-1];
            if (i >= 2) res = Math.min(res, dp[i-2]);
            else res = 0;

            dp[i] = res + (i == n - 1 ? 0 : cost[i]);
        }
        return dp[n-1];
    }
}
