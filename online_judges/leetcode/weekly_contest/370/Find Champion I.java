class Solution {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        int[] p = new int[n];
        Arrays.fill(p, -1);
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if (grid[i][j] == 1) p[j] = i;
            }
        }
        
        int ans = -1;
        for(int i=0;i<n;i++) {
            if (p[i] == -1) {
                if (ans == -1) ans = i;
                else {
                    ans = -1;
                    break;
                }
            }
        }
        return ans;
    }
}
