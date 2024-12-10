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

    public static long part1(List<String> lines) {
        char[][] grid = getGrid(lines);
        int n = grid.length;
        int m = grid[0].length;
        Map<Character, List<P>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != '.') {
                    List<P> ps = map.getOrDefault(grid[i][j], new ArrayList<>());
                    ps.add(new P(i, j));
                    map.put(grid[i][j], ps);
                }
            }
        }
        Set<P> ants = new HashSet<>();
        for (Character c : map.keySet()) {
            List<P> ps = map.get(c);
            for (int i = 0; i < ps.size(); i++) {
                for (int j = 0; j < ps.size(); j++) {
                    if (i == j) continue;
                    P p1 = ps.get(i);
                    P p2 = ps.get(j);

                    int diffi = p1.i - p2.i;
                    int diffj = p1.j - p2.j;

                    int cnt = isPart2 ? 0 : 1;
                    while (true) {
                        int ii = p1.i + cnt * diffi;
                        int jj = p1.j + cnt * diffj;
                        if (cnt > 1 && !isPart2) break;
                        if (ii >= 0 && ii < n && jj >= 0 && jj < m) ants.add(new P(ii, jj));
                        else break;
                        cnt++;
                    }
                }
            }
        }

        return ants.size(); // 348
    }

    record P(int i, int j) {}

    public static char[][] getGrid(List<String> lines) {
        char[][] grid = new char[lines.size()][];
        int cnt = 0;
        for (String line : lines) grid[cnt++] = line.toCharArray();
        return grid;
    }

    public static long part2(List<String> lines) {
        isPart2 = true;
        return part1(lines); //1221
    }

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
