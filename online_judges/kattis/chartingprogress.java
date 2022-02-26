
import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;

//    static char[][] grid;

    public static void main(String[] args){
        InputStream is;
        try {
            is = new FileInputStream(".\\src\\in.txt");
        } catch (FileNotFoundException e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);
        solve(in, out);
        out.close();
    }

    static void solve(InputReader is, PrintWriter out) {
        List<String> lines = new ArrayList<>();

        while (true) {
            try{
                String s = is.next();

                if (lines.size() > 0 && (lines.get(0).length() != s.length() || checkAtericks(lines))) {
                    solveOne(getGrid(lines), out);
                    lines = new ArrayList<>();

                    lines.add(s);
                }
                else{
                    lines.add(s);
                }
            }catch (NullPointerException e) {
                break;
            }
        }
        if(lines.size() > 0) solveOne(getGrid(lines), out);
    }
    static boolean checkAtericks(List<String> lines){
        int cnt = 0;
        for (String line: lines) {
            for (char c : line.toCharArray()) {
                if(c == '*') cnt++;
            }
        }
        return cnt == lines.get(0).length();
    }
    static char[][] getGrid(List<String> lines) {
        char[][] grid = new char[lines.size()][lines.get(0).length()];
        for(int i=0;i<lines.size();i++) {
            grid[i] = lines.get(i).toCharArray();
        }
        return grid;
    }
    static void solveOne(char[][] grid, PrintWriter out) {

        int n = grid.length, m = grid[0].length;
        char[][] res = new char[n][m];
        int i = n-1, j = 0;
        while (i >= 0) {
            for (int k=0;k<m;k++) {
                if (grid[i][k] == '*') res[i][j++] = '*';
            }
            i--;
        }
        for (i=0;i<n;i++){
            for (j=0;j<m;j++) {
                if (res[i][j] == '*') out.print(res[i][j]);
                else out.print('.');
            };
            out.println();
        }
        out.println();
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