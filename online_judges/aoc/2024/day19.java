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
        long ans = 0;
        String[] patterns = lines.get(0).split(", ");
        for(int i=2;i<lines.size();i++) {

            String line = lines.get(i);
            dp = new long[line.length()];
            Arrays.fill(dp, -1);
            long cnt = isPossible(0, lines.get(i), patterns);
            ans += isPart2 ? cnt : Math.min(cnt, 1);
        }
        return ans; // 365
    }

    static long isPossible(int idx, String d, String[] patterns) {
        if (idx >= d.length()) return 1;
        if (dp[idx] != -1) return dp[idx];
        long res = 0;
        for(String p:patterns) {
            if (d.indexOf(p, idx) == idx) {
                res += isPossible(idx+p.length(),d,patterns);
            }
        }

        return dp[idx] = res;
    }

    public static long part2(List<String> lines) {
        isPart2 = true;
        return part1(lines); // 730121486795169
    }

    record P(int i, int j, int dir, long cost) { }
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