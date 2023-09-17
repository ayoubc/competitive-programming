Download file
import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;

    static char[][] grid;

    public static void main(String[] args) {


        InputStream is;
        try {
            is = new FileInputStream(".\\src\\input\\in.txt");
        } catch (Exception e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);
        int a = in.nextInt();
        int b = in.nextInt();
        int k = in.nextInt();

        int ans = 0;
        for (int x = a; x <= b; x++) {
            boolean ok = true;
            for (int q=2; q<=k; q++) {
                if (!isPalindromic(x, q)) {
                    ok = false;
                    break;
                }
            }
            ans += ok ? 1 : 0;
        }
        out.println(ans);
        out.close();
    }

    static private boolean isPalindromic(int x, int q) {
        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            int r = x % q;
            sb.append(r);
            x /= q;
        }
        char[] base = sb.toString().toCharArray();
        int n = base.length;
        for (int i=0;i<n/2;i++) {
            if (base[i] != base[n-1-i]) return false;
        }
        return true;
    }
    static class P {
        int index, level;

        public P(int i, int l) {
            index = i;
            level = l;
        }
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
