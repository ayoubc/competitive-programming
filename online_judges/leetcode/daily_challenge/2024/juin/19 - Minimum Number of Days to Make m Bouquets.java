class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n / k < m) return -1;
        int l = 0;
        int r = (int)1e09 + 1;
        int ans = 0;
        while (l < r) {
            int mid = (l + r) / 2;
            if (ok(mid, m, k, bloomDay)) {
                ans = mid;
                r = mid;
            }
            else l = mid + 1;
        }
        return ans;
    }
    private boolean ok(int x, int m, int k, int[] bloomDay) {
        int ans = 0;
        int cnt = 0;
        for(int day : bloomDay) {
            if (day <= x) cnt++;
            else {
                ans += cnt / k;
                cnt = 0;
            }
        }
        ans += cnt / k;
        return ans >= m;
    }
}