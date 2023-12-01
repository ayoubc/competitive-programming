class Solution {
    private static String[] garbage;
    private static int[] travel;
    public int garbageCollection(String[] garbage, int[] travel) {
        this.garbage = garbage;
        this.travel = travel;
        return solve('M') + solve('G') + solve('P');
    }
    private int solve(char c) {
        int maxI = -1;
        for(int i=0;i<this.garbage.length;i++) {
            int cnt = count(c, this.garbage[i]);
            if (cnt > 0) maxI = i;
        }
        int ans = 0;
        for(int i=0;i<=maxI;i++) {
            int cnt = count(c, this.garbage[i]);
            if (cnt > 0) {
                ans += cnt;
            }
            ans += (i == maxI ? 0 : this.travel[i]);
        }
        return ans;
    }
    private int count(char c, String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++) {
            if (c == s.charAt(i)) ans ++;
        }
        return ans;
    }
}