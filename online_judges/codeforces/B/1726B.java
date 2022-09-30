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
            is = new FileInputStream(".\\src\\input\\in.txt");
        } catch (Exception e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();

            if (n == 1) {
                sb.append("Yes\n" + m);
            }
            else if (m == n) {
                sb.append("Yes\n");
                for (int i=1;i<=n;i++) sb.append("1 ");
            }
            else if ( m > n) {

                int X = -1;
                int y = 0;
                for (y=0;y<n;y+=2) {
                    if ((m - y) % (n - y) == 0) {
                        X = n - y;
                        break;
                    }
                }

                if (X == -1) sb.append("No");
                else{
                    sb.append("Yes\n");
                    for(int i=1; i<= n - X; i++) sb.append("1 ");
                    int Q = (m - y) / X;
                    for(int i=1; i<= X; i++) sb.append(Q + " ");
                }
            }
            else sb.append("No");
            sb.append("\n");
        }
        out.println(sb);
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
        public long nextLong() {
            return Long.parseLong(next());
        }
        public double nextDouble() {return Double.parseDouble(next());}
        public String readLine() throws IOException{
            return reader.readLine();
        }
    }
}
