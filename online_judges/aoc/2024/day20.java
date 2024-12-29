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
    static int[][] visited;
    static int time = 1;
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
        grid = getGrid(lines);
        N = grid.length;
        M = grid[0].length;
        Point start = null;
        Point end = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(grid[i][j] == 'S') start = new Point(i, j);
                if(grid[i][j] == 'E') end = new Point(i, j);
            }
        }
        int saves = 100;
        visited = new int[N][M];
        P orgPath = bfsPath(start, end);
        int ans = 0;

        for(int i=0;i<orgPath.path.size();i++) {
            Point p = orgPath.path.get(i);
            for(int k=0;k<4;k++) {
                int ii = dx[k]+p.i;
                int jj = dy[k]+p.j;
                if (ii < 0 || ii >= N || jj < 0 || jj >= M) continue;
                if (grid[ii][jj] == '#') {
                    // one step
                    grid[ii][jj] = '.';
                    Point s = new Point(ii, jj);
                    int cheat = bfsSteps(s, end);
                    grid[ii][jj] = '#';
                    if (cheat == -1) continue;
                    if (orgPath.path.size() - (i+1 + cheat) >= saves) ans++;
                }
            }
        }

        return ans; // 1343
    }

    public static P bfsPath(Point start, Point end) {
        P res = null;
        Queue<P> q = new LinkedList<>();
        P p = new P(start, new ArrayList<>());
        p.path.add(start);
        visited[start.i][start.j] = ++time;
        q.add(p);
        while (!q.isEmpty()) {
            P cur = q.poll();
            if (cur.p.i == end.i && cur.p.j == end.j) {
                res = cur;
                break;
            }
            for(int k=0;k<4;k++) {
                int ii = dx[k]+cur.p.i;
                int jj = dy[k]+cur.p.j;
                if (ii < 0 || ii >= N || jj < 0 || jj >= M || grid[ii][jj] == '#') continue;

                if (visited[ii][jj] != time) {
                    visited[ii][jj] = time;
                    Point nxt = new Point(ii, jj);
                    List<Point> path = new ArrayList<>(cur.path);

                    path.add(nxt);
                    q.add(new P(nxt, path));
                }
            }
        }
        return res;
    }

    public static int bfsSteps(Point start, Point end) {
        int res = -1;
        Queue<PP> q = new LinkedList<>();
        visited[start.i][start.j] = ++time;
        q.add(new PP(start, 0));
        while (!q.isEmpty()) {
            PP cur = q.poll();
            if (cur.p.i == end.i && cur.p.j == end.j) {
                res = cur.steps;
                break;
            }
            for(int k=0;k<4;k++) {
                int ii = dx[k]+cur.p.i;
                int jj = dy[k]+cur.p.j;
                if (ii < 0 || ii >= N || jj < 0 || jj >= M || grid[ii][jj] == '#') continue;

                if (visited[ii][jj] != time) {
                    visited[ii][jj] = time;
                    q.add(new PP(new Point(ii, jj), cur.steps+1));
                }
            }
        }
        return res;
    }

    public static long part2(List<String> lines) {
        // I had to look to hint, because I calculated cheats from any point on path to any point with
        // manhaten dist less then max cheats, I was getting more number of cheats
        // but it turns out, i only had to compute cheats from a point on path to another point on path
        grid = getGrid(lines);
        N = grid.length;
        M = grid[0].length;
        Point start = null;
        Point end = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(grid[i][j] == 'S') start = new Point(i, j);
                if(grid[i][j] == 'E') end = new Point(i, j);
            }
        }
        visited = new int[N][M];
        int saves = 100;
        int maxCheats = 20;
        P orgPath = bfsPath(start, end);

        Map<Integer, Integer> occ = new HashMap<>();

        for(int i=0;i<orgPath.path.size();i++) {
            Point p1 = orgPath.path.get(i);
            for(int j=i+1;j<orgPath.path.size();j++) {
                Point p2 = orgPath.path.get(j);
                int cheat = Math.abs(p1.i - p2.i) + Math.abs(p1.j - p2.j);
                int diff = j - i - cheat;
                if (cheat <= maxCheats && diff >= saves) {
                    occ.put(diff, occ.getOrDefault(diff, 0)+1);
                }
            }
        }

        return occ.keySet().stream().sorted().peek(ss -> {
            System.out.println("There are " + occ.get(ss) + " cheats that save " + ss + " picoseconds");
        }).map(occ::get).reduce(0, Integer::sum); // 982891
    }
    public static char[][] getGrid(List<String> lines) {
        char[][] grid = new char[lines.size()][];
        int cnt = 0;
        for (String line : lines) grid[cnt++] = line.toCharArray();
        return grid;
    }

    record Point(int i, int j) {}
    record P(Point p, List<Point> path) { }
    record PP(Point p, int steps) { }
    record PPP(int i1, int j1, int i2, int j2) { }
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