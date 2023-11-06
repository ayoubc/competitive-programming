class Solution {
    public static int[][] rs;
    public static int[][] dp;
    public int maximumRequests(int n, int[][] requests) {
        int nr = requests.length;
        rs = requests;
        dp = new int[nr][2 << nr];
        for(int i=0;i<nr;i++) for(int j=0;j<(1 << nr);j++) dp[i][j] = -1;
        return f(0, 0, nr, n);
    }
    private int f(int idx, int subset, int nr, int n) {
        if (idx >= nr) {
            int[] occ = new int[n];
            int cnt = 0;
            for(int i=0;i<nr;i++) {
                if (((1 << i) & subset) != 0) {
                    occ[rs[i][0]]--;
                    occ[rs[i][1]]++;
                    cnt++;
                }
            }
            for(int i=0;i<n;i++) {
                if (occ[i] != 0) return 0;
            }
            return cnt;
        }
        if(dp[idx][subset] != -1) return dp[idx][subset];

        return dp[idx][subset] = Math.max(f(idx+1, subset, nr, n), f(idx+1, subset|(1 << idx), nr, n));
    }
}