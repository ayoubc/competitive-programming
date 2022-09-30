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
    static int k;
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
            k = in.nextInt();

            long[] E = new long[n];
            for (int i=0;i<n;i++) E[i] = in.nextLong();

            long A = 0;
            long B = 0;
            long S = 0;
            for (int i=0;i<n;i++) {
                B += E[i];
                S += E[i] * E[i];
                for (int j=i+1;j<n;j++) A += E[i] * E[j];
            }

            List<Long> res = new ArrayList<>();

            while (A != 0 && k > 0) {
                int tmpK = k;
                long tmpA = A;
                long tmpB = B;
                long tmpS = S;
                List<Long> tmpRes = new ArrayList<>();
                while (tmpA != 0 && tmpK > 0) {
//                    if (tmpS + 2 * tmpA == tmpB * tmpB) break;
                    if (tmpB == 0) {
                        break;
                    }

                    long C = -tmpA/tmpB;
                    tmpRes.add(C);

                    tmpA += C*tmpB;
                    tmpB += C;
                    tmpS += C * C;
                    tmpK--;
                }
                if (tmpA == 0) {
                    for (Long l: tmpRes) res.add(l);
                    break;
                }
                else{
                    k--;
                    res.add(tmpA);
                    A += tmpA * B;
                    B += tmpA;
                    S += tmpA * tmpA;
                }
            }

            out.print("Case #" + tt + ": ");
            if (B * B != S + 2 * A || k <= 0) out.print("IMPOSSIBLE");
            else {
                if (res.size() == 0) res.add(0L);
                for(Long l:res) out.print(l+" ");
            }
            out.println();
        }

        out.close();
    }
    static void copy(boolean[] s, boolean[] d) {
        for (int i=0;i<d.length;i++) s[i] = d[i];
    }
    static class Pair {
        public String s;
        boolean vis[];
        int total;
        public Pair (String s, boolean[] vis, int t) {
            this.s = s;
            this.vis = vis;
            total = t;
        }
    }
    static boolean isValid(String s) {
        boolean[] vis = new boolean[26];
        int i = 0 ;
        while (i<s.length()) {
            if (vis[s.charAt(i) - 'A']) return false;
            vis[s.charAt(i) - 'A'] = true;
            int j = i;
            while (j < s.length() && s.charAt(i) == s.charAt(j) ) j++;
            i = j;
        }
        return true;
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
