class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0;
        int n = s.length();
        int m = t.length();
        for(int j=0;j<n;j++) {
            if (i < m && s.charAt(j) == t.charAt(i)) i++;
        }
        return m - i;
    }
}