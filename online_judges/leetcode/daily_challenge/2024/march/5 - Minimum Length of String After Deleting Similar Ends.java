class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int i = 0;
        int j = n-1;
        int sz = n;
        while (i < n && j >= 0 && i < j) {
            if (s.charAt(i) != s.charAt(j)) break;

            char c = s.charAt(i);
            while (i < n && c == s.charAt(i)) {
                i++;
                sz--;
            }
            while (j >= 0 && c == s.charAt(j)) {
                j--;
                sz--;
            }
        }
        return Math.max(sz, 0);
    }
}