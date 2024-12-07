class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] col = new int[m];
        int[] row = new int[n];
        for(int i=0;i<n;i++) {
            row[i] = matrix[i][0];
            for(int j=0;j<m;j++) row[i] = Math.min(row[i], matrix[i][j]);
        }
        for(int j=0;j<m;j++) {
            col[j] = matrix[0][j];
            for(int i=0;i<n;i++) col[j] = Math.max(col[j], matrix[i][j]);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if (matrix[i][j] == row[i] && matrix[i][j] == col[j]) ans.add(matrix[i][j]);
            }
        }
        return ans;
    }
}