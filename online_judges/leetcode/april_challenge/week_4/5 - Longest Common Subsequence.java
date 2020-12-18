class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        int[][] dp = new int[n][m];
        dp[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 :  0;
        for(int i=1;i<n;i++) {
            dp[i][0] = text1.charAt(i) == text2.charAt(0) ? 1 : dp[i-1][0];
        }
        for(int i=1;i<m;i++) {
            dp[0][i] = text1.charAt(0) == text2.charAt(i) ? 1 : dp[0][i-1];
        }
        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++) {
                if (text1.charAt(i) == text2.charAt(j)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n-1][m-1];
    }
}