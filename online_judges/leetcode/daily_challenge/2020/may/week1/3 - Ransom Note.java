class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransOcc = new int[26];
        int[] magOcc = new int[26];
        
        for(int i=0;i<ransomNote.length();i ++) {
            ransOcc[ransomNote.charAt(i) - 'a']++;
        }
        
        for(int i=0;i<magazine.length();i ++) {
            magOcc[magazine.charAt(i) - 'a']++;
        }
        
        for(int i=0;i<26;i++) {
            if (ransOcc[i] > magOcc[i]) return false;
        }
        return true;
    }
}