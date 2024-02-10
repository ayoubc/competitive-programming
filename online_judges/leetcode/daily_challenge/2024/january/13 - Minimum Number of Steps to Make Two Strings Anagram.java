class Solution {
    public int minSteps(String s, String t) {
        int[] occs = new int[26];
        int[] occt = new int[26];
        for(int i=0;i<s.length();i++) {
            occs[s.charAt(i) - 'a']++;
            occt[t.charAt(i) - 'a']++;
        }
        int ans = 0;
        for(int i=0;i<26;i++) {
            ans -= Math.min(0, occt[i]-occs[i]);
        }
        return ans;
    }
}