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

        int t = in.nextInt();
        for (int tt=1;tt<=t;tt++){
            int r = in.nextInt();
            int c = in.nextInt();
            out.println("Case #" + tt + ":");
            out.println(".." + getRoWSep(c-1));
            for (int i=0;i<r;i++) {
                out.println(getRow(i, c));
                out.println(getRoWSep(c));
            }
        }
        out.close();
    }
    static String getRoWSep(int c) {
        String s = "";
        for (int i=0;i<=c;i++) {

            s += '+';
            if(i<c) s += '-';
        }
        return s;
    }
    static String getRow(int i, int c) {
        String s = "";
        for (int j=0;j<=c;j++) {
            if (i == 0 && j == 0) s += '.';
            else s += '|';
            if (j < c) s += '.';
        }
        return s;
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