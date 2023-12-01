class Solution {
    private static int mod = 1000000007;
    private int[][] dp;
    private static int[][] map = {
        {4, 6}, // 0
        {6, 8}, // 1
        {7, 9}, // 2
        {4, 8}, // 3
        {0 ,3, 9}, // 4
        {}, // 5
        {0, 1, 7}, // 6
        {2, 6}, // 7
        {1, 3}, // 8
        {2, 4} // 9
    };
    private int[] f1379;
    public int knightDialer(int n) {
        dp = new int[10][n+1];
        int ans = 0;
        for(int r=0;r<10;r++) {
            ans = (ans + solve(r, n-1)) % mod;
        }
        return ans;
    }
    private int solve(int root, int l) {
        if (l == 0) return 1;
        if (dp[root][l] != 0) return dp[root][l];
        int ans = 0;
        for(int nextRoot: map[root]) {
            ans = (ans + solve(nextRoot, l-1)) % mod;
        }
        return dp[root][l] = ans;
    }
}