class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int prev = 0;
        int ans = 0;
        for(int i=0;i<n;i++) {
            int ones = 0;
            for(int j=0;j<bank[i].length();j++) ones += bank[i].charAt(j) - '0';
            if (ones > 0) {
                ans += ones * prev;
                prev = ones;
            }
        }
        return ans;
    }
}