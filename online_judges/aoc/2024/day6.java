import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Main {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static char[] arrows = {'>', 'v', '<', '^'};
    static boolean isPart2 = false;
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;

    static char[][] grid;
    static InputReader in;
    static PrintWriter out;

    public static void main(String[] args){

        InputStream is;
        try {
            is = new FileInputStream(".\\src\\input\\in.txt");
        } catch (Exception e) {
            is = System.in;
        }
        in = new InputReader(is);
        out = new PrintWriter(System.out);
        List<String> lines = new ArrayList<>();
        while(true) {
            try{
                String line = in.readLine();
                if (line.isBlank()) break;
                lines.add(line);
            }
            catch (Exception e) {
                break;
            }
        }
        out.println(part2(lines));
        out.close();
    }

    public static long part1(List<String> lines) {
        char[][] grid = toGrid(lines);
        int n = grid.length;
        int m = grid[0].length;
        int inDir = -1;
        int starti = -1;
        int startj = -1;

        outerLoop:
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                for (int k=0;k<4;k++) {
                    if (grid[i][j] == arrows[k]) {
                        inDir = k;
                        starti = i;
                        startj = j;
                        break outerLoop;
                    }
                }
            }
        }
        int si = starti;
        int sj = startj;
        int dir = inDir;
        boolean[][] visited = new boolean[n][m];
        while (true) {
            visited[si][sj] = true;
            int nxi = dx[dir] + si;
            int nxj = dy[dir] + sj;
            if (nxi < 0 || nxi >= n || nxj < 0 || nxj >= m) break;
            if (grid[nxi][nxj] == '#') dir = (dir + 1) % 4;
            else {
                si = nxi;
                sj = nxj;
            }
        }
        int ans = 0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) ans += visited[i][j] ? 1:0;
        }
        return ans;
    }

    public static char[][] toGrid(List<String> lines) {
        char[][] grid = new char[lines.size()][];
        int cnt=0;
        for (String line : lines) {
            grid[cnt++] = line.toCharArray();
        }
        return grid;
    }
    public static long part2(List<String> lines) {
        char[][] grid = toGrid(lines);
        int n = grid.length;
        int m = grid[0].length;
        int inDir = -1;
        int starti = -1;
        int startj = -1;

        outerLoop:
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                for (int k=0;k<4;k++) {
                    if (grid[i][j] == arrows[k]) {
                        inDir = k;
                        starti = i;
                        startj = j;
                        break outerLoop;
                    }
                }
            }
        }
        int ans = 0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (grid[i][j] == '.') {
                    grid[i][j] = '#';
                    int si = starti;
                    int sj = startj;
                    int dir = inDir;
                    int cnt = 0;
                    boolean loop = false;
                    while (true) {
                        if (cnt >= n * m) {
                            loop = true;
                            break;
                        }
                        cnt++;
                        int nxi = dx[dir] + si;
                        int nxj = dy[dir] + sj;
                        if (nxi < 0 || nxi >= n || nxj < 0 || nxj >= m) break;
                        if (grid[nxi][nxj] == '#') dir = (dir + 1) % 4;
                        else {
                            si = nxi;
                            sj = nxj;
                        }
                    }
                    grid[i][j] = '.';
                    ans += loop ? 1 : 0;
                }
            }
        }
        return ans;
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
        public double nextDouble() {return Double.parseDouble(next());}
        public String readLine() throws IOException{
            return reader.readLine();
        }
    }
}
