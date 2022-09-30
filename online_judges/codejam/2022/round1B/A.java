import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;

    static char[][] grid;
    static int[] D;
    static int n;
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
            n = in.nextInt();

            D = new int[n];
            for (int i=0;i<n;i++) D[i] = in.nextInt();

            int ans = 0;
            int i = 0;
            int j = n-1;
            int maxAll = 0;
            while (i<=j) {
                int tmp = -1;
                if (D[i] <= D[j]) {
                    tmp = D[i];
                    i++;
                }
                else{
                    tmp = D[j];
                    j--;
                }
                if(tmp >= maxAll) ans++;
                maxAll = Math.max(maxAll, tmp);
            }

            out.println("Case #" + tt + ": " + ans);
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
        public String readLine() throws IOException{
            return reader.readLine();
        }
    }
}
