class Solution {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] sum = new int[r][c];
        sum[0][0] = grid[0][0];
        for(int i=1;i<r;i++) {
            sum[i][0] = sum[i-1][0] + grid[i][0];
        }
        for(int i=1;i<c;i++) {
            sum[0][i] = sum[0][i-1] + grid[0][i];
        }  
        for(int i=1;i<r;i++) {
            for(int j=1;j<c;j++) {
                sum[i][j] = grid[i][j] + Math.min(sum[i-1][j], sum[i][j-1]);
            }
        }
        return sum[r-1][c-1];
    }
}