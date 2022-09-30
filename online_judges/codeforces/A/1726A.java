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
        } catch (Exception e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];

            for (int i=0;i<n;i++) arr[i] = in.nextInt();


            int ans = arr[n-1] - arr[0];
            for (int i=0;i<n-1;i++) {
                ans = Math.max(ans, arr[i] - arr[i+1]);
            }
            for (int i=1;i<n;i++) {
                ans = Math.max(ans, arr[i] - arr[0]);
            }
            for (int i=n-2;i>=0;i--) {
                ans = Math.max(ans, arr[n-1] - arr[i]);
            }
            out.println(ans);
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
