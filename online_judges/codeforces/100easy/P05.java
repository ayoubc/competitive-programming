import java.io.*;
import java.util.*;


public class P05 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        char[] s = in.next().toCharArray();

        int cnt = 1;
        for(int i=1;i<s.length;i++) {
            if(cnt >= 7) break;
            if(s[i] == s[i-1]) {
                cnt ++;
            }
            else cnt = 1;
        }
        out.println(cnt >= 7 ? "YES" : "NO");
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
