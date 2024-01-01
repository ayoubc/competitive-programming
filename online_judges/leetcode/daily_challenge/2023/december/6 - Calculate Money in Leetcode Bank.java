class Solution {
    public int totalMoney(int n) {
        int ans = 0;
        for(int i=0;i<n;i++) {
            int q = i / 7;
            int k = i % 7;
            ans += q + k + 1;
        }
        return ans;
    }
}