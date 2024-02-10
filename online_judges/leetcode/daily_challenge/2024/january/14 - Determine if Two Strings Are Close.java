class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] occ1 = new int[26];
        int[] occ2 = new int[26];
        if (word1.length() != word2.length()) return false;
        for(int i=0;i<word1.length();i++) {
            occ1[word1.charAt(i) - 'a']++;
            occ2[word2.charAt(i) - 'a']++;
        }
        for(int i=0;i<26;i++) {
            if (occ1[i] != occ2[i] && (occ1[i] == 0 || occ2[i] == 0)) return false;
        }
        Arrays.sort(occ1);
        Arrays.sort(occ2);
        for(int i=0;i<26;i++) if (occ1[i] != occ2[i]) return false;
        return true;
    }
}