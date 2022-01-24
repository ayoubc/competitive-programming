
import java.io.*;
import java.util.*;


public class P11 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int q = in.nextInt();

        int[] col = new int[n];
        int[] row = new int[n];
        int[] leftDiag = new int[2 * n - 1];
        int[] rightDiag = new int[2 * n - 1];

        StringBuilder ans = new StringBuilder();
        while (q-- > 0) {
            int x = in.nextInt();
            int y = in.nextInt();
            x--; y--;
            boolean ok = (row[x] == 0 && col[y] == 0 && leftDiag[x+y] == 0 && rightDiag[n-1-x+y] == 0);
            if(ok) {
                row[x] = 1;
                col[y] = 1;
                leftDiag[x+y] = 1;
                rightDiag[n-1-x+y] = 1;
            }
            ans.append((ok ? "YES" : "NO") + "\n");
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
