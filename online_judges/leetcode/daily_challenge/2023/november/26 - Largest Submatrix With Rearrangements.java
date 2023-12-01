class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] preC = new int[r][c];

        for(int j=0;j<c;j++) {
            preC[0][j] = matrix[0][j] * -1;
            for(int i=1;i<r;i++) {
                if (matrix[i][j] == 1) preC[i][j] = preC[i-1][j] - 1;
                else preC[i][j] = 0;
            }
        }

        int ans = 0;
        for(int i=0;i<r;i++) {
            Arrays.sort(preC[i]);
            for(int j=0;j<c;j++) {
                ans = Math.max(ans, (j + 1) * preC[i][j] * -1);
            }
        }
        return ans;
    }
}