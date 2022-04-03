
import java.io.*;
import java.util.*;


public class AtcoderHeuristicPractice {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;

    static char[][] grid;

    public static void main(String[] args){
        InputStream is;
        OutputStream outfile;
        try {
            is = new FileInputStream(".\\src\\in.txt");
            outfile = new FileOutputStream(".\\src\\out.txt");
        } catch (FileNotFoundException e) {
            is = System.in;
            outfile = System.out;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(outfile);

        int D = in.nextInt();
        int[] C = new int[26];
        for (int i=0;i<26;i++) C[i] = in.nextInt();

        int[][] S = new int[D][26];
        for (int i=0;i<D;i++)
            for (int j=0;j<26;j++) S[i][j] = in.nextInt();

        int[] ans = solve(D, S, C);

        for (int d=0;d<D;d++) out.println(ans[d]);

        out.close();
    }

    static int[] solve(int D, int[][] S, int[] C) {
        int[] ans = new int[D];
        boolean[] vis = new boolean[26];

        int[] last = new int[D];
        for (int d=0;d<D;d++) {
            int index = -1;
            int maxS = -36505;
//            int maxS = 36505;
            if ((d+1) % 26 == 0) {
                vis = new boolean[26];
            }
            for (int j=0;j<26;j++) {
                if (vis[j]) continue;
                if (maxS == S[d][j]) {
                    if (C[j] * (d + 1 - last[j]) < C[index] * (d + 1 - last[index])) index = j;
                }
                else if (maxS < S[d][j]) {
                    maxS = S[d][j];
                    index = j;
                }

                if (maxS < S[d][j] - C[j] * (d + 1 - last[j])) {
                    maxS = S[d][j] - C[j] * (d + 1 - last[j]);
                    index = j;
                }
            }
            ans[d] = index+1;
            last[index] = d+1;
            vis[index] = true;
        }
        return ans;
    }

    static int score(int D, int[][] S, int[] C, int[] out) {
        int sat = 0;
        int[] last = new int[26];
        for (int d=0;d<D;d++) {
            int j = out[d] - 1;
            last[j] = d+1;
            for (int i=0;i<26;i++) sat -= (d + 1 - last[i]) * C[i];
            sat += S[d][j];
        }

        return  Math.max(0, 1000000 + sat);
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