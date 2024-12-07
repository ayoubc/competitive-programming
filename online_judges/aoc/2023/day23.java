import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static InputReader in;
    static PrintWriter out;
    static int ans = 0;
    static boolean isPart2;

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
    private static boolean isValid(int i, int j, int n, int m) {
        return i >=0 && i<n && j>=0 && j<m;
    }
    static char[][] readGrid(List<String> lines) {
        int n = lines.size();
        int m = lines.get(0).length();
        char[][] res = new char[n][m];
        for (int i=0;i<n;i++) res[i] = lines.get(i).toCharArray();
        return res;
    }
    static class P {
        int i, j;
        char tile;
        int dist;
        public P(int _i, int _j, char tile, int d) {
            i = _i;
            j = _j;
            this.tile = tile;
            this.dist = d;
        }
        public List<P> getNexts(char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            List<P> res = new ArrayList<>();
            for (int k=0;k<4;k++) {
                int I = i + dx[k];
                int J = j + dy[k];
                if (isValid(I, J, n, m) && grid[I][J] != '#') {
                    if (!isPart2) {
                        if (tile == '.') {
                            if ((dx[k] == 1 && grid[I][J] == '^')
                                    || (dx[k] == -1 && grid[I][J] == 'v')
                                    || (dy[k] == 1 && grid[I][J] == '<')
                                    || (dy[k] == -1 && grid[I][J] == '>')) continue;
                        }
                        if ((tile == '>' && (dy[k] != 1 || grid[I][J] == '<'))
                                || (tile == '<' && (dy[k] != -1 || grid[I][J] == '>'))
                                || (tile == '^' && (dx[k] != -1 || grid[I][J] == 'v'))
                                || (tile == 'v' && (dx[k] != 1 || grid[I][J] == '^'))) continue;
                    }
                    res.add(new P(I, J, grid[I][J], dist+1));
                }
            }
            return res;
        }
    }

    static void backtrack(P s, int ei, int ej, char[][] grid, boolean[][] vis) {
        if (s.i == ei && s.j == ej) {
            ans = Math.max(ans, s.dist);
            return;
        }
        List<P> nexts = s.getNexts(grid);
        for (P p: nexts) {
            if (!vis[p.i][p.j]) {
                vis[p.i][p.j] = true;
                backtrack(p, ei, ej, grid, vis);
                vis[p.i][p.j] = false;
            }
        }
    }

    static int part1(List<String> lines) {
        char[][] grid = readGrid(lines);
        int n = grid.length;
        int m = grid[0].length;
        int si = 0;
        int sj = 1;
        int ei = n-1;
        int ej = m-2;
        ans = 0;
        boolean[][] vis = new boolean[n][m];
        backtrack(new P(si, sj, '.', 0), ei, ej, grid, vis);
        return ans;
    }

    static long part2(List<String> lines) {
        // will take sometime around 11 min
        // we can use edge contraction to accelrate the search by reducing options
        // consider tile with more than 3 adjacent as the only vertices of the graph
        isPart2 = true;
        return part1(lines);
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