class Solution {
    public int integerBreak(int n) {
        
        int ans = 1;
        for(int a=1;a<n;a++) {
            int q = n / a;
            int r = n % a;
            if (q == 1) {
                ans = Math.max(ans, a * r);
            }
            if (q >= 2) {
                ans = Math.max(ans, power(a, q-1) * (a + r));
                ans = Math.max(ans, power(a, q) * r);
            }
        }
        return ans;
    }
    private int power(int x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        int b = power(x, n / 2);
        b *= b;
        if (n % 2 == 1) b *= x;
        return b;
    }
}