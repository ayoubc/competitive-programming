class Solution {
    static int[] dp;
    public int numDecodings(String s) {
        int n = s.length();
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, s);
    }

    private int solve(int idx, String s) {
        if (idx == s.length()) return 1;
        if (dp[idx] != -1) return dp[idx];
        if (s.charAt(idx) == '0') return dp[idx] = 0;
        
        int res = solve(idx+1, s);
        if (idx + 1 <= s.length()-1) {
            int x = Integer.valueOf(s.substring(idx, idx+2));
            if (x<=26) {
                res += solve(idx+2, s);
            }

        }
        
        return dp[idx] = res;
    }
}