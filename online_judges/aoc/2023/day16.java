import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static InputReader in;
    static PrintWriter out;

    public static void main(String[] args) {
        InputStream is;
        try {
            is = new FileInputStream(".\\src\\input\\in.txt");
        } catch (Exception e) {
            is = System.in;
        }
        in = new InputReader(is);
        out = new PrintWriter(System.out);

        String line = null;
        List<String> lines = new ArrayList<>();
        while ((line = in.readLine()) != null) lines.add(line);
        out.println(part2(lines));
        out.close();
    }
    static char[][] readGrid(List<String> lines) {
        int n = lines.size();
        int m = lines.get(0).length();
        char[][] grid = new char[n][m];
        for (int i=0;i<n;i++) grid[i] = lines.get(i).toCharArray();
        return grid;
    }
    static long bfs(int si, int sj, char sIn, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<Tile> q = new LinkedList<>();
        q.add(new Tile(si, sj, grid[si][sj], sIn));
        vis[si][sj] = 1;
        while (!q.isEmpty()) {
            Tile cur = q.poll();
            List<Tile> nexts = cur.getNext(grid);
            for (Tile t: nexts) {
                if (vis[t.i][t.j] < n) {
                    vis[t.i][t.j]++;
                    q.add(t);
                }
            }
        }
        long ans = 0;
        for (int i=0;i<n;i++) for (int j=0;j<m;j++) {
            if (vis[i][j] > 0) ans++;
        }
        return ans;
    }
    static long part1(List<String> lines) {
        char[][] grid = readGrid(lines);
        return bfs(0, 0, 'l', grid);
    }

    static long part2(List<String> lines) {
        char[][] grid = readGrid(lines);
        int n = grid.length;
        int m = grid[0].length;
        char[] sJIn = {'l', 'r'};
        char[] sIIn = {'d', 'u'};
        int[] sI = {0, n-1};
        int[] sJ = {0, m-1};
        long ans = 0;
        for (int k=0;k<2;k++) {
            for (int i=0;i<n;i++) {
                long res = bfs(i, sJ[k], sJIn[k], grid);
                ans = Math.max(ans, res);
            }
            for (int j=0;j<m;j++) {
                long res = bfs(sI[k], j, sIIn[k], grid);
                ans = Math.max(ans, res);
            }
        }
        return ans;
    }
    static class Tile {
        int i, j;
        char type; // . \ | / -
        char dIn; // r, l, u, d
        static String dirs = "lrud";
        public Tile(int i, int j, char t, char in) {
            this.i = i;
            this.j = j;
            type = t;
            dIn = in;
        }
        public List<Tile> getNext(char[][] grid) {
            List<Tile> res = new ArrayList<>();
            char[] outs = getOutDirection();
            int n = grid.length;
            int m = grid[0].length;
            for (char c: outs) {
                int k = dirs.indexOf(c);
                int I = this.i+dx[k];
                int J = this.j+dy[k];
                if (isValid(I, J, n, m))  res.add(new Tile(I, J, grid[I][J], getOpposite(c)));
            }
            return res;
        }
        public boolean isValid(int i, int j, int n, int m) {
            return (i >= 0 && i < n) && (j >= 0 && j < m);
        }
        public char getOpposite(char c) {
            if (c == 'l') return 'r';
            if (c == 'r') return 'l';
            if (c == 'u') return 'd';
            return 'u';
        }
        public char[] getOutDirection() {
            String res = "";
            if (type == '.') {
                if (dIn == 'r') res += 'l';
                if (dIn == 'l') res += 'r';
                if (dIn == 'u') res += 'd';
                if (dIn == 'd') res += 'u';
            }
            if (type == '\\') {
                if (dIn == 'r') res += 'u';
                if (dIn == 'l') res += 'd';
                if (dIn == 'u') res += 'r';
                if (dIn == 'd') res += 'l';
            }
            if (type == '|') {
                if (dIn == 'r' || dIn == 'l') res += "ud";
                if (dIn == 'u') res += 'd';
                if (dIn == 'd') res += 'u';
            }
            if (type == '-') {
                if (dIn == 'u' || dIn == 'd') res += "lr";
                if (dIn == 'l') res += 'r';
                if (dIn == 'r') res += 'l';
            }
            if (type == '/') {
                if (dIn == 'r') res += 'd';
                if (dIn == 'l') res += 'u';
                if (dIn == 'u') res += 'l';
                if (dIn == 'd') res += 'r';
            }
            return res.toCharArray();
        }

    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String readLine() {
            try {
                return reader.readLine();
            } catch (IOException ex) {
                return null;
            }
        }
    }
}