import java.io.*;
import java.util.*;


public class P03 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        StringBuilder ans = new StringBuilder();

        while(n-- > 0) {
            String w = in.next();
            if (w.length() > 10) {
                int l = w.length();
                w = w.charAt(0) + String.valueOf(l - 2) + w.charAt(l-1);
            }
            ans.append(w + "\n");
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
