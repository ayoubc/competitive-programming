
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

        Pair[] points = new Pair[3];
        for (int i=0;i<3;i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            points[i] = new Pair(x, y);
        }

        if (points[0].y == points[1].y) {
            if(points[1].x == points[2].x) out.println(points[0].x + " " + points[2].y);
            else out.println(points[1].x + " " + points[2].y);
        }
        else if (points[0].x == points[1].x) {
            if(points[1].y == points[2].y) out.println(points[2].x + " " + points[0].y);
            else out.println(points[2].x + " " + points[1].y);
        }
        else{
            if(points[1].x == points[2].x) out.println(points[0].x + " " + points[1].y);
            else out.println(points[1].x + " " + points[0].y);
        }

        out.close();
    }


    static class Pair{
        public int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
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
    }
}