import java.io.*;
import java.util.*;



public class Main {
    static int[] dx = {0, 1, 0, -1, 1,1,-1,-1};
    static int[] dy = {1, 0, -1, 0, 1,-1,-1,1};
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
        List<String> lines = new ArrayList<>();
        while(true) {
            try{
                String line = in.readLine();
                if (line.isBlank()) break;
                lines.add(line);
            }
            catch (Exception e) {
                break;
            }
        }
        out.println(part2(lines));
        out.close();
    }

    public static long part1(List<String> lines) {
        char[][] grid = toGrid(lines);
        int ans = 0;

        String word = "XMAS";
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                for (int k=0;k<8;k++) {
                    // check direction
                    ans += checkDirection(word, i, j, dx[k], dy[k], grid) ? 1 : 0;
                }
            }
        }
        return ans;
    }

    public static boolean checkDirection(String word, int i, int j, int si, int sj, char[][] grid) {
        int curI = i;
        int curJ = j;

        for (int k=0;k<word.length();k++) {
            if (curI >= grid.length || curI < 0 || curJ >= grid[i].length || curJ < 0 || grid[curI][curJ] != word.charAt(k)) {
                return false;
            }
            curI += si;
            curJ += sj;
        }
        return true;
    }

    public static char[][] toGrid(List<String> lines) {
        char[][] grid = new char[lines.size()][];
        int cnt=0;
        for (String line : lines) {
            grid[cnt++] = line.toCharArray();
        }
        return grid;
    }
    public static long part2(List<String> lines) {
        char[][] grid = toGrid(lines);
        int ans = 0;
        int[] dx = {1,1,-1,-1};
        int[] dy = {1,-1,-1,1};

        String word = "MAS";
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                int cnt = 0;
                if (checkDirection(word, i, j, 1, 1, grid)
                        && (checkDirection(word, i+2, j, -1, 1, grid)
                        ||checkDirection(word, i, j+2, 1, -1, grid))) cnt++;

                if (checkDirection(word, i, j, 1, -1, grid)
                        && (checkDirection(word, i+2, j, -1, -1, grid)
                        ||checkDirection(word, i, j-2, 1, 1, grid))) cnt++;

                if (checkDirection(word, i, j, -1, 1, grid)
                        && (checkDirection(word, i-2, j, 1, 1, grid)
                        ||checkDirection(word, i, j+2, -1, -1, grid))) cnt++;
                if (checkDirection(word, i, j, -1, -1, grid)
                        && (checkDirection(word, i-2, j, 1, -1, grid)
                        ||checkDirection(word, i, j-2, -1, 1, grid))) cnt++;

                ans += cnt;

            }
        }
        return ans/2;
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
