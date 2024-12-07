import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static InputReader in;
    static PrintWriter out;
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
        out.println(part1(lines));
        out.close();
    }
    static int getMAXN() {
        return isPart2 ? 26501365 : 64;
    }
    private static boolean isValid(int i, int j, int n, int m) {
        return i>=0 && i<n && j>=0 && j<m;
    }
    static char[][] readModules(List<String> lines) {
        int n = lines.size();
        int m = lines.get(0).length();
        char[][] res = new char[n][m];
        for (int i=0;i<n;i++) res[i] = lines.get(i).toCharArray();
        return res;
    }
    static class P {
        int i, j;
        public P(int _i, int _j) {
            i = _i;
            j = _j;
        }
    }
    static int[][] bfs(int si, int sj, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<P> q = new LinkedList<>();
        q.add(new P(si, sj));
        int[][] dist = new int[n][m];
        while (!q.isEmpty()) {
            P cur = q.poll();
            for (int k=0;k<4;k++) {
                int I = cur.i + dx[k];
                int J = cur.j + dy[k];
                if (isValid(I, J, n, m) && grid[I][J] == '.' && dist[I][J] == 0) {
                    dist[I][J] = dist[cur.i][cur.j] + 1;
                    q.add(new P(I, J));
                }
            }
        }
        return dist;
    }
    static int[] getStart(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] res = new int[2];
        outerLoop:
        for (int i=0;i<n; i++) {
            for (int j=0;j<m;j++) {
                if (grid[i][j] == 'S') {
                    grid[i][j]= '.';
                    res[0] = i;
                    res[1] = j;
                    break outerLoop;
                }
            }
        }
        return res;
    }
    static int part1(List<String> lines) {
        char[][] grid = readModules(lines);
        int n = grid.length;
        int m = grid[0].length;
        int[] start = getStart(grid);
        int si = start[0];
        int sj = start[1];

        int[][] dist = bfs(si, sj, grid);
        int ans = 0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (dist[i][j]>getMAXN()) continue;
                if (si == i && sj == j) ans++;
                else if (dist[i][j] > 0 && (getMAXN() - dist[i][j]) % 2 == 0) ans++;
            }
        }
        return ans;
    }

    static long part2(List<String> lines) {
        return 0;
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