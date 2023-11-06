class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;

        int[][] ans = new int[r][c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if (i == 0 && j == 0) ans[i][j] = 1 - obstacleGrid[i][j];
                else if (i == 0){
                    ans[i][j] = obstacleGrid[i][j] == 1 ? 0 : ans[i][j - 1];
                }
                else if (j == 0) {
                    ans[i][j] = obstacleGrid[i][j] == 1 ? 0 : ans[i - 1][j];
                }
                else ans[i][j] = obstacleGrid[i][j] == 1 ? 0 : ans[i - 1][j] + ans[i][j - 1];
            }
        }
        return ans[r - 1][c - 1];
    }
}