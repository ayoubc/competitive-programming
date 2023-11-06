class Solution {
    private static boolean[][] dp;
     
    public String longestPalindrome(String s) {
        int n = s.length();
        dp = new boolean[n][n];
        int[] ans = new int[]{0, 0};
        for(int i=0;i<n;i++) dp[i][i] = true;
            
        for(int l=1;l<=n;l++) {
            for(int i=0;i<n-l+1;i++) {
                int j = i+l-1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = (i+1 > j-1) ? true : dp[i+1][j-1];
                    if (dp[i][j]) {
                        ans[0] = i;
                        ans[1] = j;
                    }
                }
            }
        }
        return s.substring(ans[0], ans[1]+1);
    }
}