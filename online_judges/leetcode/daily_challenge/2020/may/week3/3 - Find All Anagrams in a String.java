class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indexs = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        int[][] occS = new int[n][26];
        int[] occP = new int[26];
        for (int i=0;i<m;i++){
            occP[p.charAt(i) - 'a']++;
        }
        for(int i=0;i<n;i++){
            int j = s.charAt(i) - 'a';
            for(int k=0;k<26;k++){
                if(i == 0){
                    if(j == k) occS[i][j] = 1;
                    else occS[i][k] = 0;
                }
                else{
                    if(j == k) occS[i][j] = occS[i - 1][j] + 1;
                    else occS[i][k] = occS[i - 1][k];
                }
            }
        }
        for(int i=0;i<n-m+1;i++){
            boolean ok = true;
            for(int j=0;j<26;j++){
                int o = 0;
                if(i == 0) {
                    o = occS[i+m-1][j];
                }
                else{
                    o = occS[i+m-1][j] - occS[i-1][j];
                }
                if(o != occP[j]) ok = false;
            }

            if (ok) indexs.add(i);
        }
        return indexs;
    }
}