class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        return check(s1, s2) || check(s2, s1);
    }
    
    public boolean check(String s1, String s2) {
        int[] occ = new int[26];
        for(int i=0;i<26;i++) occ[i] = 0;
        int n = s1.length();
        for(int i=0;i<n;i++) {
            occ[s1.charAt(i) - 'a'] ++;
        }
        
        boolean ok = true;
        for(int i=0;i<n;i++) {
            int k = s2.charAt(i) - 'a';
            boolean flag = false;
            for(int j=k;k>=0;k--) {
                if (occ[k] > 0) {
                    occ[k] --;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                ok = false;
                break;
            }
        }
        
        return ok;
    }
}