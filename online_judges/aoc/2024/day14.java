import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[] arrows = {'>', 'v', '<', '^'};
    static int mod = (1 << 31) - 1;
    static long OO = (long) Math.pow(10, 13);
    static List<Integer>[] graph;
    static boolean isPart2 = false;
    static int N = 103; // 7
    static int M = 101; // 11
    static char[][] grid;
    static int comps = 0;
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
                if (line == null) break;
                lines.add(line);
            } catch (Exception e) {
                System.err.println(e);
                break;
            }
        }
        out.println(part2(lines));
        out.close();
    }

    public static R getR(String line) {
        String[] parts = line.split(" ");
        String[] p = parts[0].replace("p=", "").split(",");
        String[] v = parts[1].replace("v=", "").split(",");
        return new R(new int[]{Integer.parseInt(p[0]), Integer.parseInt(p[1])},
                new int[]{Integer.parseInt(v[0]), Integer.parseInt(v[1])});
    }
    public static long part1(List<String> lines) {
        List<R> robots = lines.stream().map(Main::getR).toList();
        int[][] cnt = compute(robots, 100);

        P[][] qs = new P[][]{
                new P[] {new P(0, 0), new P(N/2, M/2)},
                new P[] {new P(0, M/2 + 1), new P(N/2, M)},
                new P[] {new P(N/2+1, 0), new P(N, M/2)},
                new P[] {new P(N/2+1, M/2+1), new P(N, M)},
        };
        int ans = 1;
        for (int k=0;k<4;k++) {
            int cur = 0;
            for (int i=qs[k][0].i;i<qs[k][1].i;i++){
                for (int j=qs[k][0].j;j<qs[k][1].j;j++) cur += cnt[i][j];
            }
            ans *= cur;
        }
        return ans; //29517
    }

    public static int[][] compute(List<R> robots, long repeat) {
        int[][] cnt = new int[N][M];
        for (R r:robots) {
            long j = (r.p[0] + r.v[0] * repeat) % M;
            long i = (r.p[1] + r.v[1] * repeat) % N;

            cnt[(int)(i+N)%N][(int)(j+M)%M]++;
        }
        return cnt;
    }

    public static long part2(List<String> lines) {
        List<R> robots = lines.stream().map(Main::getR).toList();

        int ans= 0;
        for (int t=1;t<100000;t++) {
            int[][] cnt = compute(robots, t);
            grid = new char[N][M];
            for (int i=0;i<N;i++) {
                for (int j=0;j<M;j++) {
                    if (cnt[i][j] > 0) grid[i][j] = '#';
                    else grid[i][j] = '.';
                }
            }
            boolean[][] vis = new boolean[N][M];
            boolean tree = false;
            loop:
            for (int i=0;i<N;i++) {
                for (int j=0;j<M;j++) {
                    if (!vis[i][j] && grid[i][j] == '#') {
                        comps = 0;
                        dfs(i, j, vis);
                        if (comps >= 100) {
                            System.out.println(comps);
                            ans = t;
                            tree = true;
                            break loop;
                        }
                    }
                }
            }
            if (tree) {
                System.out.println(t);
                printGrid();
                break;
            }
        }
        return ans;
    }
    public static void dfs(int i, int j, boolean[][] vis) {
        vis[i][j] = true;
        comps++;
        for (int k=0;k<4;k++) {
            int ii = dx[k]+i;
            int jj = dy[k]+j;
            if (ii < 0 || ii >= N || jj < 0 || jj >= M || grid[ii][jj] == '.') continue;
            if (!vis[ii][jj]) dfs(ii, jj, vis);
        }
    }
    public static void printGrid() {
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) System.out.print(grid[i][j]);
            System.out.println();
        }
    }
    record P(int i, int j) { }
    record R(int[] p, int[] v) {};
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String readLine() throws IOException {
            return reader.readLine();
        }
    }
}