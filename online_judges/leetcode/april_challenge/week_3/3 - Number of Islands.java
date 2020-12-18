class Solution {
    private int[] dx = {0, -1, 0, 1};
    private int[] dy = {1, 0, -1, 0};
    private boolean[][] visited;
    private char[][] grid;
    private int r, c;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.r = grid.length;
        if (this.r == 0) return 0;
        this.c = grid[0].length;
        this.visited = new boolean[r][c];
        for(int i=0;i<this.r;i++) {
            for(int j=0;j<this.c;j++) visited[i][j] = false;
        }
        
        int ans = 0;
        for(int i=0;i<this.r;i++) {
            for(int j=0;j<this.c;j++) {
                if (this.grid[i][j] == '1' && !this.visited[i][j]) {
                    ans ++;
                    this.dfs(i, j);
                }
            }
        }
        return ans;
    }
    
    boolean valid(int i, int j) {
        return (i>=0 && i<this.r && j>=0 && j<this.c && this.grid[i][j] == '1' && !this.visited[i][j]) ;
    }
    
    public void dfs(int i, int j){
        this.visited[i][j] = true;
        for(int k=0;k<4;k++) {
            int I = i + this.dx[k];
            int J = j + this.dy[k];
            if(this.valid(I, J)) {
                this.dfs(I, J);
            }
        }
    }
    
}