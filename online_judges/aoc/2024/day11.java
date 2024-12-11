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
    static Map<Long, long[]> dp;
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
        List<Long> cur = Arrays.stream(lines.get(0).split(" "))
                .map(Long::parseLong).toList();
        int repeat = isPart2 ? 75 : 25;
        dp = new HashMap<>();
        long ans = 0;
        for (long x : cur) ans += generate(x, repeat);
        return ans; // 183620
    }
    static long generate(long x, int k) {
        if (k == 0) return 1;
        if (dp.containsKey(x) && dp.get(x)[k] != -1) return dp.get(x)[k];
        long[] arr;
        if (dp.containsKey(x)) arr = dp.get(x);
        else {
            arr = new long[(isPart2 ? 75 : 25)+1];
            Arrays.fill(arr, -1);
        }
        long res = 0;
        if (x == 0) res = generate(1, k-1);
        else {
            String s = String.valueOf(x);
            if (s.length() % 2 == 0) {
                res = generate(Long.parseLong(s.substring(0, s.length()/2)), k-1)
                        + generate(Long.parseLong(s.substring(s.length()/2)), k-1);
            }
            else res = generate(x * 2024L, k-1);
        }
        arr[k] = res;
        dp.put(x, arr);
        return res;
    }
    public static long part2(List<String> lines) {
        isPart2 = true;
        return part1(lines); // 220377651399268
    }
    record P(long x, int k) { }

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