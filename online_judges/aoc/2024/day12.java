import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[] arrows = {'>', 'v', '<', '^'};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;
    static boolean isPart2 = false;
    static char[][] grid;
    static Map<Long, long[]> dp;
    static long area = 0;
    static long per = 0;
    static List<P> fs;
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
        List<String> lines = new ArrayList<>();

        while (true) {
            try {
                String line = in.readLine();
                if (line.isBlank()) {
                    break;
                }
                lines.add(line);
            } catch (Exception e) {
                break;
            }
        }
        out.println(part2(lines));
        out.close();
    }

    public static char[][] toGrid(List<String> lines) {
        char[][] grid = new char[lines.size()][];
        int cnt=0;
        for (String line : lines) {
            grid[cnt++] = line.toCharArray();
        }
        return grid;
    }

    public static long part1(List<String> lines) {
        char[][] grid = toGrid(lines);
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        long ans = 0;

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (!vis[i][j]) {
                    area = 0;
                    per = 0;
                    fs = new ArrayList<P>();
                    dfs(i, j, grid, vis);
                    long sides = 0;
                    if (isPart2) {
                        sides += colSide(fs, arrows[0]);
                        sides += colSide(fs, arrows[2]);
                        sides += rowSide(fs, arrows[1]);
                        sides += rowSide(fs, arrows[3]);
                        ans += sides * area;
                    }
                    else ans += area * per;
                }
            }
        }
        return ans; // 1467094
    }

    static int colSide(List<P> l, char c) {
        List<P> vList = l.stream()
                .filter(p -> p.c == c)
                .sorted(Comparator.comparingInt((P p) -> p.j)
                        .thenComparingInt(p -> p.i))
                .toList();

        int res = 0;
        int v = vList.size() >= 1 ? 1:0;
        for (int ii=1;ii<vList.size();ii++) {
            P p1 = vList.get(ii);
            P p2 = vList.get(ii - 1);
            if (p1.j == p2.j
                    && p1.i - p2.i == 1){
                v++;
            }
            else {
                res += Math.min(v, 1);
                v = 1;
            }
        }
        res += Math.min(v, 1);
        return res;
    }
    static int rowSide(List<P> l, char c) {
        List<P> hList = l.stream()
                .filter(p -> p.c == c)
                .sorted(Comparator.comparingInt((P p) -> p.i)
                        .thenComparingInt(p -> p.j))
                .toList();
        int res = 0;
        int h = hList.size() >= 1 ? 1:0;
        for (int ii=1;ii<hList.size();ii++) {
            P p1 = hList.get(ii);
            P p2 = hList.get(ii - 1);
            if (p1.i == p2.i
                    && p1.j - p2.j == 1){
                h++;
            }
            else {
                res += Math.min(h, 1);
                h = 1;
            }
        }
        res += Math.min(h, 1);
        return res;
    }
    static void dfs(int i, int j, char[][] grid, boolean[][] vis) {
        vis[i][j] = true;
        area++;
        for (int k=0;k<4;k++){
            int ii = dx[k] + i;
            int jj = dy[k] + j;
            if (ii < 0 || ii >= grid.length
                    || jj < 0 || jj >= grid[0].length
                    || grid[ii][jj] != grid[i][j]) {
                per++;
                P p = new P(ii, jj, arrows[k]);
                fs.add(p);
            }
            else if (!vis[ii][jj]) dfs(ii, jj, grid, vis);
        }
    }

    public static long part2(List<String> lines) {
        isPart2 = true;
        return part1(lines); // 881182
    }
    record P(int i, int j, char c) { }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String readLine() throws IOException {
            return reader.readLine();
        }
    }
}