import java.io.*;
import java.util.*;


public class P04 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        char[] a = in.next().toLowerCase().toCharArray();
        char[] b = in.next().toLowerCase().toCharArray();

        int n = Math.min(a.length, b.length);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < b[i]) {
                ans = -1;
                break;
            }
            else if (a[i] > b[i]) {
                ans = 1;
                break;
            }
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
