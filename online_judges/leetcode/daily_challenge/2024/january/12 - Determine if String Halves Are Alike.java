class Solution {
    public boolean halvesAreAlike(String s) {
        int total = 0;
        int half = 0;
        int n = s.length();
        String v = "aeiouAEIOU";
        for(int i=0;i<n;i++) {
            if (v.indexOf(s.charAt(i)) != -1) {
                if (i < n/2) half++;
                total++;
            }
        }
        return total%2 != 0 ? false : (half * 2 == total);
    }
}