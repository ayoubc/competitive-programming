import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;

    static char[][] grid;
    static int[] C = new int[3];
    static int[] M = new int[3];
    static int[] Y = new int[3];
    static int[] K = new int[3];
    static int total = 1000000;

    public static void main(String[] args){
        InputStream is;
        try {
            is = new FileInputStream(".\\src\\input\\in.txt");
        } catch (FileNotFoundException e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
        for (int tt=1;tt<=t;tt++){

            int[] values = new int[4];
            for (int i=0;i<4;i++) values[i] = total;
            for (int i=0;i<3;i++) {
                C[i] = in.nextInt();
                M[i] = in.nextInt();
                Y[i] = in.nextInt();
                K[i] = in.nextInt();

                values[0] = Math.min(C[i], values[0]);

                values[1] = Math.min(M[i], values[1]);

                values[2] = Math.min(Y[i], values[2]);

                values[3] = Math.min(K[i], values[3]);

            }

            out.print("Case #" + tt + ": ");

            int x = 0;
            for (int i=0;i<4;i++) x += values[i];
            if (x < total) out.println("IMPOSSIBLE");
            else{
                for (int i=0;i<4;i++) {
                    int tmp = values[i];
                    values[i] = Math.max(0, values[i] - (x - total));
                    x -= tmp - values[i];
                }
                for (int i=0;i<4;i++) out.print(values[i] + " ");
                out.println();
            }
        }
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
    }
}