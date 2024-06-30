class Solution {
    public boolean judgeSquareSum(int c) {
        int max = (int)Math.sqrt(c) + 1;
        for (int a=0;a<max;a++) {
            int b = c - a * a;
            int q = (int)Math.sqrt(b);
            if (q * q == b) return true;
        }
        return false;
    }
}