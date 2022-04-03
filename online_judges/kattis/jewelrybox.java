import java.io.*;
import java.util.*;


public class Main {
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


        int t = in.nextInt();
        while(t-- > 0) {
            double x = in.nextDouble();
            double y = in.nextDouble();

            double l = 0;
            double r = Math.min(x/2, y/2);
            double ans = ternary_search(l, r, x, y);

            // aternative
            /*
            double detla = (x - y) * (x - y) + x * y;

            double h = (x + y - Math.sqrt(detla)) / 6;
             */

            out.println(ans);

        }
        out.close();
    }

    static double f(double h, double a, double b) {
        return h * a * b;
    }

    static double ternary_search(double l, double r, double x, double y) {
        double eps = 1e-9;              //set the error limit here
        while (r - l > eps) {
            double m1 = l + (r - l) / 3;
            double m2 = r - (r - l) / 3;
            double f1 = f(m1, Math.max(0, x - 2 * m1), Math.max(0, y - 2 * m1));      //evaluates the function at m1
            double f2 = f(m2, Math.max(0, x - 2 * m2), Math.max(0, y - 2 * m2));      //evaluates the function at m2
            if (f1 < f2)
                l = m1;
            else
                r = m2;
        }
        return f(l, Math.max(0, x - 2 * l), Math.max(0, y - 2 * l));                    //return the maximum of f(x) in [l, r]
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