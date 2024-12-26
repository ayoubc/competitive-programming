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
        boolean[][] visited = new boolean[N][M];
        visited[start.i][start.j] = true;
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

                if (!visited[ii][jj]) {
                    visited[ii][jj] = true;
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
        boolean[][] visited = new boolean[N][M];
        visited[start.i][start.j] = true;
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

                if (!visited[ii][jj]) {
                    visited[ii][jj] = true;
                    q.add(new PP(new Point(ii, jj), cur.steps+1));
                }
            }
        }
        return res;
    }

    public static long part2(List<String> lines) {
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
        int saves = 50;
        int maxCheats = 20;
        P orgPath = bfsPath(start, end);
//        int ans = 0;
//        Map<Integer, Integer> occ = new HashMap<>();
//        for(int i=0;i<orgPath.path.size();i++) {
//            Point p = orgPath.path.get(i);
//            List<PPP> possible = new ArrayList<>();
//            Queue<PPP> q = new LinkedList<>();
//            q.add(new PPP(p, new ArrayList<>(), 0));
//            Set<Point> seen = new HashSet<>();
//            while (!q.isEmpty()) {
//                PPP cur = q.poll();
//                for(int k=0;k<4;k++) {
//                    int ii = dx[k]+p.i;
//                    int jj = dy[k]+p.j;
//                    if (ii < 0 || ii >= N || jj < 0 || jj >= M) continue;
//                    Point nxt = new Point(ii, jj);
//                    if (seen.contains(nxt)) continue;
//                    if (grid[ii][jj] == '#') {
//                        // one step
//                        if (cur.cheats.size() < maxCheats) {
//                            seen.add(nxt);
//                            List<Point> cheats = new ArrayList<>(cur.cheats);
//                            cheats.add(nxt);
//                            PPP tmp = new PPP(nxt, cheats, cur.steps+1);
//                            possible.add(tmp);
//                            q.add(tmp);
//                        }
//                    }
//                    else {
//                        seen.add(nxt);
//                        q.add(new PPP(new Point(ii, jj), cur.cheats, cur.steps+1));
//                    }
//                }
//            }
//            for (PPP ppp: possible) {
//                for(Point point:ppp.cheats) {
//                    grid[point.i][point.j] = '.';
//                }
//                int cheat = bfsSteps(ppp.cheats.getLast(), end);
//                for(Point point:ppp.cheats) {
//                    grid[point.i][point.j] = '#';
//                }
//                if (cheat == -1) continue;
//                int ss = orgPath.path.size() - (i+1 + ppp.steps + cheat);
//                occ.put(ss, occ.getOrDefault(ss, 0) + 1);
//                //if (orgPath.path.size() - (i+1 + ppp.steps + cheat) >= saves) ans++;
//            }
//
//        }

        Map<Integer, Integer> occ = new HashMap<>();
        Queue<PPP> q = new LinkedList<>();
        PPP ppp = new PPP(start, 0, new HashSet<>());
        ppp.steps.add(start);
        q.add(ppp);

        while (!q.isEmpty()) {
            PPP cur = q.poll();
            if (cur.p.i == end.i && cur.p.j == end.j) {
                int ss = orgPath.path.size() - cur.steps.size();
                if (ss >= saves) occ.put(ss, occ.getOrDefault(ss, 0) + 1);
                continue;
            }
            for(int k=0;k<4;k++) {
                int ii = dx[k]+cur.p.i;
                int jj = dy[k]+cur.p.j;
                if (ii < 0 || ii >= N || jj < 0 || jj >= M) continue;
                Point nxt = new Point(ii, jj);

                if (grid[ii][jj] == '#') {
                    // one step
                    if (cur.cheats < maxCheats && !cur.steps.contains(nxt)) {

                        Set<Point> steps = new HashSet<>(cur.steps);
                        steps.add(nxt);
                        //PPP tmp = new PPP(nxt, cheats, cur.steps+1);
                        //possible.add(tmp);
                        q.add(new PPP(nxt, cur.cheats+1, steps));
                    }
                }
                else if(!cur.steps.contains(nxt)) {
                    Set<Point> steps = new HashSet<>(cur.steps);
                    steps.add(nxt);
                    q.add(new PPP(nxt, cur.cheats, steps));
                }
            }
        }
        int ans = 0;
        for(Integer ss:occ.keySet()) {
            System.out.println("There are " + occ.get(ss) + " cheats that save " + ss + " picoseconds");
            ans += occ.get(ss);
        }
        return ans; //
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
    record P(Point p, List<Point> path) { }
    record PP(Point p, int steps) { }
    record PPP(Point p, int cheats, Set<Point> steps) { }
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