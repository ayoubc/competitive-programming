class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    public int latestDayToCross(int row, int col, int[][] cells) {
        int l = 1;
        int r = cells.length;
        int ans = 1;
        while(l <= r) {
            int mid = (r + l) / 2;
            if(ok(mid, row, col, cells)) {
                l = mid + 1;
                ans = mid;
            }
            else r = mid - 1;
        }
        return ans;
    }
    public boolean isValid(int i, int j, int r, int c, int[][] field) {
        return (i >= 1 && i <= r) && (j >= 1 && j <= c) && field[i][j] == 0; 
    }
    public boolean ok(int d, int r, int c, int[][] cells) {
        int[][] field = new int[r+1][c+1];
        for(int i=0;i<d;i++) field[cells[i][0]][cells[i][1]] = 1;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for(int cc=1;cc<=c;cc++) {
            if (field[1][cc] == 0) q.add(new Pair<>(1, cc));
        }
        while (!q.isEmpty()) {
            Pair<Integer, Integer> p = q.poll();
            int i = p.getKey();
            int j = p.getValue();
            if (i == r) return true;
            if (field[i][j] == -1) continue;
            field[i][j] = -1;
            for(int k=0;k<4;k++) {
                int I = i + dx[k];
                int J = j + dy[k];
                if (isValid(I, J, r, c, field)) {
                    q.add(new Pair<>(I, J));
                }
            }
        }
        return false;
    }
}