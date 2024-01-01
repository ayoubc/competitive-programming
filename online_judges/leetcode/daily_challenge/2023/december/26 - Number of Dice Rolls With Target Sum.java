class Solution {
    static int[][] dp;
    static int mod = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n][target+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i], -1);
        return solve(0, target, n, k);
    }

    private int solve(int idx, int left, int n, int k) {
        if (idx == n && left == 0) return 1;
        if (idx >= n || left < 0) return 0;
        if (dp[idx][left] != -1) return dp[idx][left];

        int res = 0;
        for(int i=1;i<=k;i++) {
            res = (res % mod + solve(idx+1, left-i, n, k) % mod) % mod;
        }
        return dp[idx][left] = res;
    }
}