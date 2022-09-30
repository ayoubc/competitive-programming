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
        } catch (FileNotFoundException e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);
        long n = in.nextLong();

        double epsilon = 1e-10;
        double l = epsilon;
        double r = 10.0;
        double ans = l;
        while (Math.abs(l - r) > epsilon) {
            double x = l + (r - l) / 2;
            if (f(x, n) < epsilon) {
                l = x;
                ans = x;
            }
            else{
                r = x;
            }
        }
        out.println(ans);
        out.close();
    }

    static double f(double x, long n) {
        return x * Math.log10(x) - Math.log10(n);
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
