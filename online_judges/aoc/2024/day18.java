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
    static int N;
    static int M;
    static long[] dp;
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
                break;
            }
        }
        out.println(part2(lines));
        out.close();
    }

    public static long part1(List<String> lines) {
        N = 70;
        M = 70;
        grid = new char[N+1][M+1];
        return solve(lines, 1024); // 344
    }
    public static int solve(List<String> lines, int limit) {
        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < M+1; j++) grid[i][j] = '.';
        }
        for(int i=0;i<Math.min(limit, lines.size());i++) {
            String line = lines.get(i);
            String[] parts = line.split(",");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            grid[y][x] = '#';
        }
        return bfs();
    }
    public static int bfs() {
        boolean[][] visited = new boolean[N+1][M+1];
        Queue<P> q = new LinkedList<>();
        q.add(new P(0, 0, 0));
        visited[0][0] = true;
        int ans = -1;
        while(!q.isEmpty()) {
            P p = q.poll();
            if (p.i == N && p.j == M) {
                ans = p.dst;
                break;
            }

            for(int k=0;k<4;k++){
                int ii = dx[k]+p.i;
                int jj = dy[k]+p.j;
                if(ii < 0 || ii > N || jj < 0 || jj > M || grid[ii][jj] == '#') continue;
                if (!visited[ii][jj]) {
                    visited[ii][jj] = true;
                    q.add(new P(ii, jj, p.dst+1));
                }
            }
        }
        return ans;
    }
    public static String part2(List<String> lines) {
        N = 70;
        M = 70;
        grid = new char[N+1][M+1];
        int l = 1;
        int r = Integer.MAX_VALUE;
        int ans = 0;
        while (l<r) {
            int mid = l + (r-l)/2;
            int cnt = solve(lines, mid);
            //System.out.println("steps "+cnt+" limit="+mid);
            if (cnt == -1) {
                ans = mid;
                r = mid-1;
            }
            else l = mid + 1;
        }
        return lines.get(ans-1); //46,18
    }

    record P(int i, int j, int dst) { }
    public static void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
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