class Solution { 
    int[] dx = {-1,0,1, 0};
    int[] dy = {0,-1,0, 1};
    boolean[][] visited;
    int r;
    int c;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        r = image.length;
        c = image[0].length;
        visited = new boolean[r][c];
        Queue<Pair> q = new LinkedList<>();
        int color = image[sr][sc];
        image[sr][sc] = newColor;
        visited[sr][sc] = true;
        q.add(new Pair(sr, sc));
        while(!q.isEmpty()) {
            Pair p = q.poll();
            
            for (int k = 0;k<4; k++) {
                int i = p.i + dx[k];
                int j = p.j + dy[k];
                if (isValid(i,j , color, image)){
                    visited[i][j] = true;
                    image[i][j] = newColor;
                    q.add(new Pair(i, j));
                }
            }
        }

        return image;
    }
    
    public boolean isValid(int i, int j, int color, int[][] image){
        return (i>=0 && i<r) && (j>=0 && j<c) && (image[i][j] == color) && (!visited[i][j]);
    }
    
    public class Pair {
        public int i;
        public int j;
        Pair(int _i, int _j) {
            i = _i;
            j = _j;
        }
    }
}