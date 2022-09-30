import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;

    static char[][] grid;

    static int MAX = 100000005;
    public static void main(String[] args){

        InputStream is;
        try {
            is = new FileInputStream(".\\src\\input\\in.txt");
        } catch (FileNotFoundException e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);

        int H = in.nextInt();
        int[] h = new int[H];

        int totalHot = 0;
        for (int i=0;i<H;i++) {
            h[i] = in.nextInt();
            totalHot += h[i];
        }

        int B = in.nextInt();
        int[] b = new int[B];

        int totalBuns = 0;
        for (int i=0;i<B;i++) {
            b[i] = in.nextInt();
            totalBuns += b[i];
        }

        int[][] hotdogs = new int[H][totalHot+1];
        int[][] buns = new int[B][totalBuns+1];

        for (int i=0;i<H;i++) {
            for (int j=1;j<=totalHot;j++) {
                hotdogs[i][j] = (j == h[i] ? 1 : MAX);
            }
        }
        for (int i=0;i<B;i++) {
            for (int j=1;j<=totalBuns;j++) {
                buns[i][j] = (j == b[i] ? 1 : MAX);
            }
        }
        for (int i=1;i<H;i++) {
            for (int j=0;j<=totalHot;j++) {
                hotdogs[i][j] = Math.min(hotdogs[i][j], hotdogs[i-1][j]);
                if (j>=h[i]) {
                    hotdogs[i][j] = Math.min(hotdogs[i][j], 1 + hotdogs[i-1][j-h[i]]);
                }
            }
        }
        for (int i=1;i<B;i++) {
            for (int j=0;j<=totalBuns;j++) {
                buns[i][j] = Math.min(buns[i][j], buns[i-1][j]);
                if (j>=b[i]) {
                    buns[i][j] = Math.min(buns[i][j], 1 + buns[i-1][j-b[i]]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        boolean found = false;
        for (int i=1;i<=Math.min(totalHot, totalBuns); i++) {
            if (buns[B-1][i] != MAX && hotdogs[H-1][i] != MAX) {
                found = true;
                ans = Math.min(ans, buns[B-1][i] + hotdogs[H-1][i]);
            }
        }

        out.println(!found ? "impossible" : ans);
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
