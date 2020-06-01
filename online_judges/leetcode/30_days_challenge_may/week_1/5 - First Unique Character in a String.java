class Solution {
    public int firstUniqChar(String s) {
        int[] occ = new int[26];
        for(int i=0;i<s.length();i++) {
            occ[s.charAt(i) - 'a']++;
        }
        
        for(int i=0;i<s.length();i++){
            if (occ[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}