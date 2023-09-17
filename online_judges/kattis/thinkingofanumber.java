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
        } catch (Exception e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);
        while (true) {
            int n = in.nextInt();
            if (n == 0) break;

            int l = 0;
            int r = -1;
            List<Integer> ds = new ArrayList<>();
            for (int i=0;i<n;i++) {
                String s1 = in.next();
                in.next();
                int x = in.nextInt();
                if (s1.charAt(0) == 'g') {
                    l = Math.max(l, x);
                }
                if (s1.charAt(0) == 'l') {
                    r = (r == -1 ? x : Math.min(r, x));
                }
                if (s1.charAt(0) == 'd') ds.add(x);
            }
            if (r == -1) out.println("infinite");
            else {
                List<Integer> ans = new ArrayList<>();
                for(int k=l+1;k<r;k++) {
                    boolean ok = true;
                    for(Integer x: ds) {
                        if (k % x != 0) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) ans.add(k);
                }
                if (ans.isEmpty()) {
                    out.println("none");
                }
                else {
                    for (Integer x : ans) out.print(x + " ");
                    out.println();
                }
            }

        }
        out.close();
    }

    static class P {
        int index, level;
        public P(int i, int l) {
            index = i;
            level = l;
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
        public String readLine() throws IOException{
            return reader.readLine();
        }
    }
}
