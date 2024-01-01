class Solution {
    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] cols = new int[m];
        int[] rows = new int[n];
        for (int i=0;i<n;i++) {
            for(int j=0;j<m;j++) rows[i] += mat[i][j];
        }
        for (int j=0;j<m;j++) {
            for(int i=0;i<n;i++) cols[j] += mat[i][j];
        }
        int ans = 0;
        for (int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if (mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1) ans++;
            }
        }
        return ans;
    }
}