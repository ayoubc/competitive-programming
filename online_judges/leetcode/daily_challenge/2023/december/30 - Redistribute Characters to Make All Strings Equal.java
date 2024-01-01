class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        int[] occ = new int[26];
        for(String word: words) {
            for(char c: word.toCharArray()) {
                occ[c - 'a']++;
            }
        }
        for(int i=0;i<26;i++) {
            if (occ[i] % n != 0) return false;
        }
        return true;
    }
}