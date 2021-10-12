class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int ans=0;
        for(int i=0;i<32;i++) {
            if ( n - m < (1<<i)) {
                ans += Math.min(m & (1<<i), n & (1<<i));
            }
        }
        return ans;
    }
}