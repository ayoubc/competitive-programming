
import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;

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
        int n = in.nextInt();

        Pair[] bs = new Pair[n];
        for (int i=0;i<n;i++) {
            int h = in.nextInt();
            int w = in.nextInt();
            bs[i] = new Pair(h, w);
        }

        long ans = 0;
        for (int i=0;i<n;i++) {
            int l = i-1;
            int r = i+1;
            if(bs[i].h == 0) continue;
            long tmp = bs[i].area();
            while (l>=0 && bs[l].h >= bs[i].h) {
                tmp += bs[i].h * bs[l].w;
                l --;
            }
            while (r<n && bs[r].h >= bs[i].h) {
                tmp += bs[i].h * bs[r].w;
                r ++;
            }
            ans = Math.max(ans, tmp);
        }
        out.println(ans * 50L);
        out.close();
    }

    static class Pair {
        public int h;
        public int w;
        public Pair(int h, int w) {
            this.h = h;
            this.w = w;
        }
        public int area() {
            return h * w;
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