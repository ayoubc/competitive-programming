
import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static int a,b,m,sigma;
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
        int t = in.nextInt();

        for (int i=0;i<t;i++) {
            long n = in.nextLong();
            String first = in.next();

            String[] players = new String[] {first,  first.equals("Bob") ? "Alice" : "Bob"};

            List<Long> primes = new ArrayList<>();
            long N = n;
            int depth = 0;
            for (long j=2; j * j <= n; j++) {
                if (n % j == 0) primes.add(j);
                while (n % j == 0) {
                    depth ++;
                    n /= j;
                }
            }
            if (n > 1) {
                depth ++;
                primes.add(n);
            }


            int ans = play(1, N, depth, -2, 2, true, primes);

            if (ans == 1) out.println(players[0]);
            else if (ans == 0) out.println("tie");
            else out.println(players[1]);
        }

        out.close();
    }

    // implementation of MiniMax Algorithm
    // Explanation https://www.youtube.com/watch?v=l-hh51ncgDI
    public static int play(long m, long n, int depth, int alpha, int beta, boolean isMaxi, List<Long> primes) {
        if (m > n) return 0;
        if (m == n) {
            if (isMaxi) return -1;
            else return 1;
        }

        if (depth <= 0) return 0;

        if (isMaxi) {
            int res = -1;
            for (Long prime : primes) {
                int eval = play(m * prime, n, depth-1, alpha, beta, false, primes);
                res = Math.max(res, eval);
                alpha = Math.max(alpha, eval);
                if (beta <= alpha) break;
            }
            return res;
        }
        else{
            int res = 1;
            for (Long prime : primes) {
                int eval = play(m * prime, n, depth-1, alpha, beta, true, primes);
                res = Math.min(res, eval);
                beta = Math.min(beta, eval);
                if (beta <= alpha) break;
            }
            return res;
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
    }
}