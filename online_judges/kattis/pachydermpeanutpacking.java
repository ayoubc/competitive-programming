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

        while (true) {
            int n = in.nextInt();
            if (n == 0) break;

            Box[] boxes = new Box[n];
            for (int i=0;i<n;i++) {
                boxes[i] = new Box(in.nextDouble(), in.nextDouble(), in.nextDouble(), in.nextDouble(), in.next());
            }

            int m = in.nextInt();
            for (int i=0;i<m;i++) {
                double x = in.nextDouble();
                double y = in.nextDouble();
                String size = in.next();

                int boxIndex = -1;
                for (int j=0;j<n;j++) {
                    if (boxes[j].isIn(x, y)) {
                        boxIndex = j;
                        break;
                    }
                }

                if (boxIndex == -1) {
                    out.println(size + " floor");
                }
                else{
                    out.println(size + " " + (boxes[boxIndex].size.equals(size) ? "correct" : boxes[boxIndex].size));
                }
            }
            out.println();
        }
        out.close();
    }

    static class Box {
        double x1, y1, x2, y2;
        String size;

        public Box(double x1, double y1, double x2, double y2, String size) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.size = size;
        }

        public boolean isIn(double x, double y) {
            return x>=x1 && x<=x2 && y>=y1 && y<=y2;
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
        public double nextDouble() {return Double.parseDouble(next());}
    }
}