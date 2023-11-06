class Solution {
    public int kthGrammar(int n, int k) {
        return solve(n, k);
    }
    private int solve(int n, int k) {
        if (n == 1) return 0;
        if (k <= (1 << (n - 2))) return solve(n-1, k);
        return 1 - solve(n-1, k - (1 << (n - 2)));
    }
}