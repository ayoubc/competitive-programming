class Solution {
    public int countPalindromicSubsequence(String s) {
        int ans = 0;
        int n = s.length();
        for(char c='a'; c<='z';c++) {
            int i= 0;
            int j= n - 1;
            while (i < n && s.charAt(i)!=c) i++;
            if (i == n) continue;
            while (j > i+1 && s.charAt(j)!=c) j--;
            if (j == i+1) continue;

            int[] occ = new int[26];
            for(int k=i+1;k<j;k++) {
                occ[s.charAt(k) - 'a'] = 1;
            }
            for(int k=0;k<26;k++) ans += occ[k];
        }
        return ans;
    }
}