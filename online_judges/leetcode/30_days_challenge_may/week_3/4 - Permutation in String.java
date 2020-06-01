class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int m = s1.length();
        int n = s2.length();
        int[] occS1 = new int[26];
        int[][] occS2 = new int[n][26];
        
        for (int i=0;i<m;i++){
            occS1[s1.charAt(i) - 'a']++;
        }
        for(int i=0;i<n;i++){
            int j = s2.charAt(i) - 'a';
            for(int k=0;k<26;k++){
                if(i == 0){
                    if(j == k) occS2[i][j] = 1;
                    else occS2[i][k] = 0;
                }
                else{
                    if(j == k) occS2[i][j] = occS2[i - 1][j] + 1;
                    else occS2[i][k] = occS2[i - 1][k];
                }
            }
        }
        for(int i=0;i<n-m+1;i++){
            boolean ok = true;
            for(int j=0;j<26;j++){
                int o = 0;
                if(i == 0) {
                    o = occS2[i+m-1][j];
                }
                else{
                    o = occS2[i+m-1][j] - occS2[i-1][j];
                }
                if(o != occS1[j]) ok = false;
            }

            if (ok) return true;
        }
        return false;
    }
}