
import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;

    static char[][] grid;


    public static void main(String[] args){
        InputStream is;
        try {
            is = new FileInputStream(".\\src\\in.txt");
        } catch (FileNotFoundException e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);

        StringBuilder sb = new StringBuilder();
        while (true) {
            try{
                int n = in.nextInt();
                if (n == 0) break;

                int k = solve(n);
                if (k == -1) sb.append("No such base");
                else sb.append(k);

                sb.append("\n");

            }catch (NullPointerException e) {break;}
        }

        out.print(sb);
        out.close();
    }

    static int solve(int n) {
        if (n == 3) return 4;

        int ans = n;
        int m = n - 3;
        int limit = (int)Math.sqrt(m) + 1;
        for (int i=1; i<limit; i++) {
            if (m % i == 0) {
                int q = m / i;
                if (n % i == 3) ans = Math.min(ans, i);
                if (n % q == 3) ans = Math.min(ans, q);
            }
        }

        if (ans == n) return -1;
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
    }
}