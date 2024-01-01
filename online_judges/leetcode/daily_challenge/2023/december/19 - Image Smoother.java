class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
        int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
        int n = img.length;
        int m = img[0].length;
        int[][] ans = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                int cnt = 1;
                ans[i][j] = img[i][j];
                for(int k=0;k<8;k++) {
                    int I = i + dx[k];
                    int J = j + dy[k];
                    if (isValid(I, J, n, m)) {
                        cnt++;
                        ans[i][j] += img[I][J];
                    }
                }
                ans[i][j] /= cnt;
            }
        }
        return ans;
    }
    private boolean isValid(int i, int j, int n, int m) {
        return i>=0 && i<n && j>=0 && j<m;
    }
}