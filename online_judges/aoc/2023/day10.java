import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static InputReader in;
    static PrintWriter out;
    static boolean isPart2 = false;
    static Map<Character, Pipe> pipeMap = Map.of(
            '|', new Pipe('|', 'n', 's'),
            '-', new Pipe('-', 'e', 'w'),
            'L', new Pipe('L', 'n', 'e'),
            'J', new Pipe('J', 'n', 'w'),
            '7', new Pipe('7', 'w', 's'),
            'F', new Pipe('F', 'e', 's')
    );
    public static void main(String[] args){

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
        out.println(part1(lines));
        out.close();
    }
    public static char[][] getGrid(List<String> lines) {
        int n = lines.size();
        int m = lines.get(0).length();
        char[][] grid = new char[n][m];
        int i = 0;
        for (String line: lines) grid[i++] = line.toCharArray();
        return grid;
    }
    static class P {
        int i, j;
        public P(int _i, int _j) {
            i = _i;
            j = _j;
        }
    }
    static class Pipe {
        char symbol;
        char[] dirs;
        public int[] dx;
        public int[] dy;
        public Pipe (char c, char ...args) {
            symbol = c;
            dirs = args.clone();
            int[][] res = getNiegbour(c);
            dx = res[0];
            dy = res[1];
        }
        private int[][] getNiegbour(char c) {
            int[][] ans = {{0, 0}, {0, 0}};
            switch (c) {
                case '|':
                    ans = new int[][]{{-1, 1}, {0, 0}};
                    break;
                case '-':
                    ans = new int[][]{{0, 0}, {-1, 1}};
                    break;
                case 'L':
                    ans = new int[][]{{-1, 0}, {0, 1}};
                    break;
                case 'J':
                    ans = new int[][]{{-1, 0}, {0, -1}};
                    break;
                case '7':
                    ans = new int[][]{{1, 0}, {0, -1}};
                    break;
                case 'F':
                    ans = new int[][]{{1, 0}, {0, 1}};
                    break;
            }
            return ans;
        }
        public boolean canConnect(Pipe p, int k) {
            char dir = connectedDir(getDir(k));
            for (char c : p.dirs) {
                if (c == dir) return true;
            }
            return false;
        }
        public char getDir(int k) {
            if (this.dx[k] == 0) {
                if (this.dy[k] == 1) return 'e';
                return 'w';
            }
            else {
                if (this.dx[k] == 1) return 's';
                return 'n';
            }
        }
    }
    private static char connectedDir(char c) {
        if (c == 's') return 'n';
        if (c == 'n') return 's';
        if (c == 'e') return 'w';
        return 'e';
    }
    private static boolean canConnectFromS(int k, Pipe p) {
        char dir;
        if (dx[k] == 0) {
            if (dy[k] == 1) dir = 'e';
            else dir = 'w';
        }
        else {
            if (dx[k] == 1) dir = 's';
            else dir = 'n';
        }
        dir = connectedDir(dir);
        for (char c : p.dirs) {
            if (c == dir) return true;
        }
        return false;
    }
    private static long part1(List<String> lines) {
        char[][] grid = getGrid(lines);
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        bfs(grid, n, m, dist);
        int ans = 0;
        for (int[] row: dist) for (int d : row) ans = Math.max(ans, d);
        return ans;
    }
    public static void bfs(char[][] grid, int n, int m, int[][] dist) {
        boolean[][] vis = new boolean[n][m];
        Queue<P> q = new LinkedList<>();
        P start = null;
        outerLoop:
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (grid[i][j] == 'S') {
                    start = new P(i, j);
                    vis[i][j] = true;
                    break outerLoop;
                }
            }
        }
        for (int k=0;k<4;k++) {
            int i = start.i + dx[k];
            int j = start.j + dy[k];
            if (isValid(i, j, n, m) && grid[i][j] != '.') {
                Pipe pipe = pipeMap.get(grid[i][j]);
                if (canConnectFromS(k, pipe)) {
                    vis[i][j] = true;
                    dist[i][j] = 1;
                    q.add(new P(i, j));
                }
            }
        }
        while (!q.isEmpty()) {
            P cur = q.poll();

            Pipe pipe = pipeMap.get(grid[cur.i][cur.j]);

            for (int k=0;k<2;k++) {
                int I = cur.i + pipe.dx[k];
                int J = cur.j + pipe.dy[k];

                if (isValid(I, J, n, m) && grid[I][J] != '.' && !vis[I][J]) {
                    Pipe next = pipeMap.get(grid[I][J]);
                    if (pipe.canConnect(next, k)) {
                        vis[I][J] = true;
                        dist[I][J] = dist[cur.i][cur.j] + 1;
                        q.add(new P(I, J));
                    }
                }
            }
        }
    }
    public static boolean isValid(int i, int j, int n, int m) {
        return (i >= 0 && i < n) && (j >= 0 && j < m);
    }

    private static long part2(List<String> lines) {
        return lines.size();
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
