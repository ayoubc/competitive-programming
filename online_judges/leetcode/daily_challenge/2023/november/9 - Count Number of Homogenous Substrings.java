class Solution {
    public int countHomogenous(String s) {
        long ans = 0;
        int OO = 1000000007;
        char[] sarr = s.toCharArray();
        int n = sarr.length;
        long cnt = 1;
        char prev = sarr[0];
        for(int i=1;i<n;i++) {
            if (prev == sarr[i]) cnt++;
            else {
                ans += (cnt * (cnt + 1)) / 2;
                ans %= OO;
                prev = sarr[i];
                cnt = 1;
            }
        }
        ans += (cnt * (cnt + 1)) / 2;
        ans %= OO;
        return (int)ans;
    }
}