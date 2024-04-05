class Solution {
    public int pivotInteger(int n) {
        int N = (n*(n+1))/2;
        int x = (int)Math.sqrt(N);
        if (x * x == N) return x;
        return -1;
    }
}