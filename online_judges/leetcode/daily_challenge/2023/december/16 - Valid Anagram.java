class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] occs = new int[26];   
        int[] occt = new int[26];
        for(int i=0;i<s.length();i++) {
            occs[s.charAt(i) - 'a']++;
            occt[t.charAt(i) - 'a']++;
        }   
        for(int i=0;i<26;i++) {
            if (occs[i] != occt[i]) return false;
        }
        return true;
    }
}