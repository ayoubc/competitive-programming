class Solution {
    public double averageWaitingTime(int[][] customers) {
        int start = 0;
        double ans = 0;
        int n = customers.length;
        for(int[] c:customers) {
            if (start > c[0]) ans += start - c[0];
            else start = c[0];
            ans += c[1];
            start += c[1];
        }
        return ans / n;
    }
}