
import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static int a,b,m,sigma;
    static char[][] grid;

    public static void main(String[] args){
        InputStream is;
        try {
            is = new FileInputStream(".\\src\\in.txt");
        } catch (FileNotFoundException e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);
        int n;
        double d;
        while(true) {
            try{
                d = in.nextDouble();
                if (d == 0.0) break;
                n = in.nextInt();
                Pair[] points = new Pair[n];
                for (int i=0;i<n;i++) {
                    double x = in.nextDouble();
                    double y = in.nextDouble();
                    points[i] = new Pair(x, y);
                }

                int ans = n;
                for(int j=0;j<n;j++){
                    for(int i=0;i<n;i++){
                        if(j!=i){
                            if(points[i].dist(points[j])<=d){
                                ans--;
                                break;
                            }
                        }
                    }
                }
                out.println(n - ans + " sour, " + ans + " sweet");
            }catch (NullPointerException e) {
                break;
            }
        }

        out.close();
    }

    static double carre(double x ){
        return x * x;
    }
    static class Pair{
        public double x, y;

        public Pair(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double dist(Pair other) {
            return Math.sqrt(carre(x - other.x) + carre(y - other.y));
        }
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
        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}