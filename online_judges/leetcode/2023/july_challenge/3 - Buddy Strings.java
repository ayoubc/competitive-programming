class Solution {
    public boolean buddyStrings(String s, String goal) {
        char[] sc = s.toCharArray();
        char[] goalc = goal.toCharArray();
        if(sc.length != goalc.length || sc.length == 1) return false;

        int cnt = 0;
        int i = -1;
        int j = -1;
       
        int[] occ = new int[26];
        for(int k=0;k<sc.length;k++) {
            if (sc[k] != goalc[k]) {
                cnt++;
                if (cnt == 1) i = k;
                else j = k;
            }
            occ[sc[k] - 'a'] ++;
        }
        if (cnt == 1 || cnt > 2) return false;
        if (cnt == 2){
            if(sc[i] == goalc[j] && sc[j] == goalc[i]) return true;
            return false;
        }
        
        
        for(int k=0;k<26;k++) {
            if(occ[k] >= 2) return true;
        }
        return false;
    }
}