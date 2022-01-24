import java.io.*;
import java.util.*;


public class P08 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n, L, a;
        n = in.nextInt();
        L = in.nextInt();
        a = in.nextInt();

        int[] t = new int[n+1];
        int[] l = new int[n];
        for (int i=0;i < n;i ++) {
            t[i] = in.nextInt();
            l[i] = in.nextInt();
        }
        t[n] = L;

        int ans = t[0] / a;
        for (int i=0;i<n;i++) ans += (t[i+1] - t[i] - l[i]) / a;
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
