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

            String[] S = new String[n];
            for (int i=0;i<n;i++) S[i] = in.next();

            boolean ok = true;
            Queue<Pair> q = new LinkedList<>();
            for (int i=0;i<n;i++) {
                HashSet<Integer> vis = new HashSet<>();
                vis.add(i);
                ok &= isValid(S[i]);
                q.add(new Pair(S[i], vis));
            }

            String ans = "IMPOSSIBLE";
            while (!q.isEmpty() && ok) {
                Pair p = q.poll();
                if (p.vis.size() == n) {
                    if (isValid(p.s)) {
                        ans = p.s;
                        break;
                    }

                }

                for (int i=0;i<n;i++) {
                    if (p.vis.contains(i)) continue;

                    if (isValid(p.s + S[i])) {
                        HashSet<Integer> vis = new HashSet<>(p.vis);
                        vis.add(i);
                        q.add(new Pair(p.s + S[i], vis));
                    }
                }
            }

            out.println("Case #" + tt + ": " + ans);
        }
        out.close();
    }
    static void copy(boolean[] s, boolean[] d) {
        for (int i=0;i<d.length;i++) s[i] = d[i];
    }
    static class Pair {
        public String s;
        public HashSet<Integer> vis;
        public Pair (String s, HashSet<Integer> vis) {
            this.s = s;
            this.vis = vis;
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
