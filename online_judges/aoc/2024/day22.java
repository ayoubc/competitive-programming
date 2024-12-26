import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[] arrows = {'>', 'v', '<', '^'};
    static long mod = 16777216;
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
        for(String line : lines) {
            long res = Long.parseLong(line);
            for(int i=1;i<=2000;i++) {
                res = generate(res);
            }
            ans += res;
        }
        return ans;
    }
    public static long generate(long start) {
        long result = start;
        result ^= result * 64;
        result %= mod;

        result ^= (result / 32);
        result %= mod;

        result ^= result * 2048;
        result %= mod;
        return result;
    }
    public static int part2(List<String> lines) {
        Map<P, Integer> map = new HashMap<>();
        for(String line : lines) {
            long res = Long.parseLong(line);
            List<Integer> seq = new ArrayList<>();
            seq.add((int)res%10);
            for(int i=1;i<=2000;i++) {
                res = generate(res);
                seq.add((int)res%10);
            }
            List<Integer> tmp = new ArrayList<>();
            Map<P, Integer> unic = new HashMap<>();
            for(int i=1;i<=2000;i++) {
                tmp.add(seq.get(i) - seq.get(i-1));
                if (tmp.size() > 4) tmp.removeFirst();
                if (tmp.size() == 4) {
                    P p = new P(tmp.get(0), tmp.get(1), tmp.get(2), tmp.get(3));
                    if (!unic.containsKey(p)) {
                        unic.put(p, seq.get(i));
                    }
                }
            }
            unic.forEach((k, v) -> {
                map.put(k, map.getOrDefault(k, 0) + v);
            });
        }
        int ans = 0;
        for(Integer d:map.values()) ans = Math.max(ans, d);
        return ans;
    }

    record P(int a, int b, int c, int d) { }

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