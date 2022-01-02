import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static int n;
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

        n = in.nextInt();
        grid = new char[n][n];

        for(int i=0;i<n;i++) {
            grid[i] = in.next().toCharArray();
        }

        long[][] dp = new long[n][n];
        dp[0][0] = 1;
        for (int j=1;j<n;j++) {
            if(grid[0][j] == '#') dp[0][j] = 0;
            else dp[0][j] = dp[0][j-1];
        }

        for (int i=1;i<n;i++) {
            if(grid[i][0] == '#') dp[i][0] = 0;
            else dp[i][0] = dp[i-1][0];
        }

        for(int i=1;i<n;i++) {
            for(int j=1;j<n;j++) {
                if(grid[i][j] == '#') dp[i][j] = 0;
                else dp[i][j] = (dp[i-1][j] % mod + dp[i][j-1] % mod) % mod;
            }
        }
        if(dp[n-1][n-1] != 0)
            out.println(dp[n-1][n-1]);
        else
            out.println(bfs() ? "THE GAME IS A LIE" : "INCONCEIVABLE");

        out.close();
    }

    static boolean isValid(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < n && grid[i][j] == '.';
    }

    static boolean bfs() {
        boolean[][] vis = new boolean[n][n];
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, 0));
        vis[0][0] = true;
        while (!q.isEmpty()) {
            Pair p = q.poll();

            if(p.i == n-1 && p.j == n-1) return true;

            for(int k=0;k<4;k++) {
                int i = dx[k] + p.i;
                int j = dy[k] + p.j;
                if(isValid(i, j) && !vis[i][j]) {
                    q.add(new Pair(i, j));
                    vis[i][j] = true;
                }
            }
        }
        return false;
    }

    static class Pair {
        public int i;
        public int j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
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
    }
}