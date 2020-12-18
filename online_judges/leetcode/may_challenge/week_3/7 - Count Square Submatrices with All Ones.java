class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        if(n == 0) return 0;
        int m = matrix[0].length;
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j] == 1)
                    matrix[i][j] = Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1])) + 1;
            }
        }
        
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) ans += matrix[i][j];
        }
        return ans;
    }
}