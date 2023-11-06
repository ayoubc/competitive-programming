class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (n < 0) {
            x = 1.0d / x;
            N *= -1l;
        }
        System.out.println(N);
        return pow(x, N);
    }
    public double pow(double x, long n) {
        if (n == 0) return 1.0d;
    
        double res = pow(x, n / 2);
        res = res * res;
        if (n % 2 == 1) res *= x;
        return res;
    }
}