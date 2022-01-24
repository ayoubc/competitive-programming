import java.io.*;
import java.util.*;


public class P10 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int[] a = new int[n];

        for(int i=0;i<n;i++) a[i] = in.nextInt();

        int ans = 0;
        int i=0;
        while (i < n) {
            int j = i+1;
            while (j<n && a[j] <= 2 * a[j-1]) j++;

            ans = Math.max(ans, j-i);
            i = j;
        }

        out.print(ans);
        out.close();

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

    }
}
