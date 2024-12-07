import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {0, 1, 0, -1, -1, -1, 1, 1};
    static int[] dy = {1, 0, -1, 0, -1, 1, 1, -1};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;

    static char[][] grid;
    static InputReader in;
    static PrintWriter out;

    public static void main(String[] args){

        InputStream is;
        try {
            is = new FileInputStream(".\\src\\input\\in.txt");
        } catch (Exception e) {
            is = System.in;
        }
        in = new InputReader(is);
        out = new PrintWriter(System.out);
        int[][] grid = new int[10][10];
        for (int i=0;i<10;i++) {
            String line = in.next();
            for(int j=0;j<10;j++) {
                grid[i][j] = line.charAt(j) - '0';
            }
        }

        out.println(part2(grid));
        out.close();
    }
    static void spredFlash(int i, int j, int[][] grid, boolean[][] flashed) {
        if (grid[i][j] <= 9) return;
        grid[i][j] = 0;
        flashed[i][j] = true;
        for(int k=0;k<8;k++) {
            int I = dx[k] + i;
            int J = dy[k] + j;
            if (isValid(I, J, 10)) {
                if (!flashed[I][J]) {
                    grid[I][J]++;
                    spredFlash(I, J, grid, flashed);
                }
            }
        }
    }
    static boolean isValid(int i, int j, int n) {
        return i>=0 && i<n && j>=0 && j<n;
    }
    static class P {
        int index, level;
        public P(int i, int l) {
            index = i;
            level = l;
        }
    }
    static int part1(int[][] grid) {
        int totalFlashes = 0;
        for (int s=0;s<100;s++){
            boolean[][] flashed = new boolean[10][10];
            for(int i=0;i<10;i++) {
                for(int j=0;j<10;j++) {
                    grid[i][j]++;
                }
            }
            for(int i=0;i<10;i++) {
                for(int j=0;j<10;j++) {
                    spredFlash(i, j, grid, flashed);
                }
            }
            for(int i=0;i<10;i++) {
                for(int j=0;j<10;j++) {
                    if (flashed[i][j]) {
                        totalFlashes++;
                    }
                }
            }
        }
        return totalFlashes;
    }
    static int part2(int[][] grid) {
        int step = 1;
        while (true) {
            boolean[][] flashed = new boolean[10][10];
            for(int i=0;i<10;i++) {
                for(int j=0;j<10;j++) {
                    grid[i][j]++;
                }
            }
            for(int i=0;i<10;i++) {
                for(int j=0;j<10;j++) {
                    spredFlash(i, j, grid, flashed);
                }
            }
            boolean allFlashed = true;
            for(int i=0;i<10;i++) {
                for(int j=0;j<10;j++) {
                    if (!flashed[i][j]) {
                        allFlashed = false;
                    }
                }
            }
            if (allFlashed) break;
            step++;
        }
        return step;
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
