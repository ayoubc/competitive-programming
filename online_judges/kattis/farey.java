
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

        int[] fary = new int[10001];
        fary[0] = 1;
        for (int i=1;i<=10000;i++) fary[i] = phi(i) + fary[i - 1];

        int p = in.nextInt();
        for (int i=0;i<p;i++) {
            int k = in.nextInt();
            int n = in.nextInt();

            out.println(k + " " + fary[n]);
        }

        out.close();
    }

    public static int phi(int n) {
        int res = n;
        for (int i=2; i*i <= n; i++) {
            if (n % i == 0) res -= res / i;
            while (n % i == 0) n /= i;
        }
        if (n > 1) res -= res / n;
        return res;
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