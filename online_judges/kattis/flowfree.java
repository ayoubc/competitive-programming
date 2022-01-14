
import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;
    static char[][] vis;
    static char[][] grid;
    static int cnt;
    static boolean found;

    public static void main(String[] args){
        InputStream is;
        try {
            is = new FileInputStream(".\\src\\in.txt");
        } catch (FileNotFoundException e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);

        grid = new char[4][4];
        vis = new char[4][4];

        for (int i=0;i<4;i++) grid[i] = in.next().toCharArray();
        for (int i=0;i<4;i++) for (int j=0;j<4;j++) vis[i][j] = 'W';

        String[] ans = new String[] {"solvable", "not solvable"};

        List<Pair> starts = new ArrayList<>();
        List<Pair> ends = new ArrayList<>();
        char[] colors = new char[] {'R','G','B','Y'};

        for (char color: colors) {
            int cnt = 0;
            for (int i=0;i<4;i++) {
                for (int j=0;j<4;j++) {
                    if (color == grid[i][j]) {
                        if (cnt == 0) starts.add(new Pair(i, j, color));
                        else ends.add(new Pair(i, j, color));
                        cnt ++;
                    }
                }
            }
        }

        solve(null, starts, ends, 0);
        int index = found ? 0 : 1;
        out.println(ans[index]);
        out.close();

    }

    static boolean isValid(int i, int j, char color) {
        return i >= 0 && i < 4 && j >= 0 && j < 4 && (grid[i][j] == 'W' || grid[i][j] == color) && vis[i][j] == 'W';
    }

    static void solve(Pair curP, List<Pair> ss, List<Pair> es, int index) {
        if (curP == null) {
            curP = ss.get(index);
            vis[curP.i][curP.j] = curP.color;
        }

        if (curP.equals(es.get(index))) {
            vis[curP.i][curP.j] = curP.color;
            if (index + 1 == ss.size()) {
                boolean ok = true;
                for (int i=0;i<4;i++) {
                    for (int j=0;j<4;j++) {
                        if (vis[i][j] == 'W') {
                            ok = false;
                            break;
                        }
                    }
                }
                if (ok) {
                    found = true;
                    return;
                }
            }
            else{
                Pair next = ss.get(index + 1);
                vis[next.i][next.j] = next.color;
                solve(next, ss, es, index+1);
            }
        }
        else{
            for (int k=0;k<4;k++) {
                int curI = curP.i + dx[k];
                int curJ = curP.j + dy[k];
                if (isValid(curI, curJ, curP.color)) {
                    vis[curI][curJ] = curP.color;
                    solve(new Pair(curI, curJ, curP.color), ss, es, index);
                    vis[curI][curJ] = 'W';
                }
            }
        }

    }

    static class Pair{
        public int i, j;
        public char color;
        public Pair(int i, int j, char color) {
            this.i = i;
            this.j = j;
            this.color = color;
        }

        public boolean equals(Pair o){
            return i == o.i && j == o.j && color == o.color;
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
        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}