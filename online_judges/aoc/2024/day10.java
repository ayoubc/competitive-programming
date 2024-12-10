import java.io.*;
import java.util.*;
import java.util.stream.IntStream;


public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[] arrows = {'>', 'v', '<', '^'};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;
    static boolean isPart2 = false;
    static char[][] grid;
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
        int ans = 0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (grid[i][j] == '0') {
                    Set<P> nines = new HashSet<>();
                    int res = score(i, j, grid, nines);
                    ans += isPart2 ? res : nines.size();
                }
            }
        }
        return ans; // 512
    }
    public static int score(int i, int j, char[][] grid, Set<P> nines) {
        if (grid[i][j] == '9') {
            nines.add(new P(i, j));
            return 1;
        }
        int res = 0;
        for (int k=0;k<4;k++) {
            int ii = dx[k] + i;
            int jj = dy[k] + j;
            if (ii < 0 || jj < 0 || ii >= grid.length || jj >= grid[0].length) continue;
            if (grid[ii][jj] - grid[i][j] == 1) {
                res += score(ii, jj, grid, nines);
            }
        }
        return res;
    }
    public static long part2(List<String> lines) {
        isPart2 = true;
        return part1(lines); // 1045
    }
    record P(int i, int j) { }

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