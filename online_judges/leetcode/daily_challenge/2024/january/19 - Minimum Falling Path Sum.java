class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][]  dp = new int[n][m];
        for(int j=0;j<n;j++) dp[0][j] = matrix[0][j];
        for(int i=1;i<n;i++) {
            for(int j=0;j<m;j++) {
                int res = dp[i-1][j];
                if (j > 0) res = Math.min(dp[i-1][j-1], res);
                if (j < m-1) res = Math.min(dp[i-1][j+1], res);
                dp[i][j] = res + matrix[i][j];
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j=0;j<m;j++) ans = Math.min(ans, dp[n-1][j]);
        return ans;
    }
}