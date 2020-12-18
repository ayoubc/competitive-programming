class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int X = coordinates[1][0] - coordinates[0][0];
        int Y = coordinates[1][1] - coordinates[0][1];
        
        // cross product for collinearity
        for(int i=2;i<coordinates.length;i++) {
            int X_i = coordinates[i][0] - coordinates[1][0];
            int Y_i = coordinates[i][1] - coordinates[1][1];
            if (X_i * Y != Y_i * X) return false;
        }
        return true;
    }
    
} 