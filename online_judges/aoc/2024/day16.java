import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[] arrows = {'>', 'v', '<', '^'};
    static int mod = (1 << 31) - 1;
    static long OO = 1000000000;
    static List<Integer>[] graph;
    static boolean isPart2 = false;
    static char[][] grid;
    static int N;
    static int M;
    static Point start = null;
    static Point end = null;
    static Point[][][] compGraph;
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
        return solve(lines, false); //105508
    }
    public static long solve(List<String> lines, boolean isPart2) {
        grid = getGrid(lines);
        N = grid.length;
        M = grid[0].length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(grid[i][j] == 'S') start = new Point(i,j);
                if(grid[i][j] == 'E') end = new Point(i,j);
            }
        }
//        compGraph = compressedGraph();
        long[][][] fromStart = dijikstra(start, getDirIdx('>'));
        long minCost = OO;
        for(int k=0;k<4;k++) {
            minCost = Math.min(minCost, fromStart[end.i][end.j][k]);
        }

        if (!isPart2) return minCost;

        boolean[][] marked = new boolean[N][M];
        marked[start.i][start.j] = true;
        marked[end.i][end.j] = true;
        for(int k=0;k<4;k++) {
            long[][][] fromEnd = dijikstra(end, k);
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if (grid[i][j] == '.') {

                        outerLoop:
                        for(int ks=0;ks<4;ks++) {
                            for(int ke=0;ke<4;ke++) {
                                long add = (Math.abs(ke-ks) == 2 ? 0L : 1000L);
                                if (fromStart[i][j][ks] + fromEnd[i][j][ke] + add == minCost) {
                                    marked[i][j] = true;
                                    break outerLoop;
                                }
                            }
                        }
                    }
                }
            }
        }
        long res = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(marked[i][j]) {
                    res++;
                    grid[i][j] = 'O';
                }
            }
        }
        printGrid();
        return res;
    }
    public static long[][][] dijikstra(Point start, int dir) {
        long[][][] dist = new long[N][M][4];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) Arrays.fill(dist[i][j], OO);
        }
        PriorityQueue<P> pq = new PriorityQueue<>(Comparator.comparingLong(p -> p.cost));
        pq.add(new P(start, dir, 0));
        dist[start.i][start.j][dir] = 0;

        while (!pq.isEmpty()) {
            P p = pq.poll();
            for(int step = -1; step <= 1; step++) {
                int k = (step+p.dir+4) % 4;
                int ii = dx[k]+p.p.i;
                int jj = dy[k]+p.p.j;
                if (ii < 0 || ii >= N || jj < 0 || jj >= M || grid[ii][jj] == '#') continue;

                long len = (k == p.dir ? 1L : 1001L);
                if (p.cost + len <= dist[ii][jj][k]) {
                    dist[ii][jj][k] = p.cost + len;
                    pq.add(new P(new Point(ii, jj), k, dist[ii][jj][k]));
                }
            }
        }
        return dist;
    }

    public static long part2(List<String> lines) {
        return solve(lines, true);
    }
    public static Point[][][] compressedGraph() {
        // create compressed graph from corners only
        Point[][][] g = new Point[N][M][4];
        boolean[][] visited = new boolean[N][M];
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visited[start.i][start.j] = true;
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int k = 0; k < 4; k++) {
                int ii = -1;
                int jj = -1;
                Point nxt = null;
                int cnt = 0;
                while (true) {
                    cnt++;
                    ii = cnt * dx[k] + p.i;
                    jj = cnt * dy[k] + p.j;
                    if (ii < 0 || ii >= N || jj < 0 || jj >= M || grid[ii][jj] == '#') break;
                    nxt = new Point(ii, jj);
                    if ((ii == p.i && (grid[ii-1][jj] != '#' || grid[ii+1][jj] != '#' ))
                            || (jj == p.j && (grid[ii][jj-1] != '#' || grid[ii][jj+1] != '#' ))) {
                        if (!visited[ii][jj]) {
                            visited[ii][jj] = true;
                            q.add(new Point(ii, jj));
                        }
                        break;
                    }
                }
                g[p.i][p.j][k] = nxt;
            }
        }
        return g;
    }
    public static long[][][] dijikstraCompressedGraph(Point start, int dir) {
        long[][][] dist = new long[N][M][4];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) Arrays.fill(dist[i][j], OO);
        }
        PriorityQueue<P> pq = new PriorityQueue<>(Comparator.comparingLong(p -> p.cost));
        pq.add(new P(start, dir, 0));
        dist[start.i][start.j][dir] = 0;

        while (!pq.isEmpty()) {
            P p = pq.poll();
            for(int step = -1; step <= 1; step++) {
                int k = (step+p.dir+4) % 4;
                Point nxt = compGraph[p.p.i][p.p.j][k];
                if (nxt != null) {
                    long len = (k == p.dir ? 0L : 1000L) + Math.abs(p.p.i - nxt.i) + Math.abs(p.p.j - nxt.j);
                    if (p.cost + len <= dist[nxt.i][nxt.j][k]) {
                        dist[nxt.i][nxt.j][k] = p.cost + len;
                        pq.add(new P(nxt, k, dist[nxt.i][nxt.j][k]));
                    }
                }
            }
        }
        return dist;
    }

    public static char[][] getGrid(List<String> lines) {
        char[][] grid = new char[lines.size()][];
        int cnt = 0;
        for (String line : lines) grid[cnt++] = line.toCharArray();
        return grid;
    }
    public static int getDirIdx(char c) {
        for (int i = 0; i < 4; i++) {
            if (arrows[i] == c) return i;
        }
        return -1;
    }
    public static void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    record Point(int i, int j) {}
    record P(Point p, int dir, long cost) { }

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