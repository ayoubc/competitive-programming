import java.io.*;
import java.util.*;


public class Main {
    static InputReader in;
    static PrintWriter out;
    static boolean isPart2 = false;
    public static void main(String[] args) {


        InputStream is;
        try {
            is = new FileInputStream(".\\src\\input\\in.txt");
        } catch (Exception e) {
            is = System.in;
        }
        in = new InputReader(is);
        out = new PrintWriter(System.out);

        String line = null;
        List<String> lines = new ArrayList<>();
        while ((line = in.readLine()) != null) lines.add(line);
        out.println(part2(lines));
        out.close();
    }
    static char[][] readGrid(List<String> lines) {
        int n = lines.size();
        int m = lines.get(0).length();
        char[][] grid = new char[n][m];
        for (int i=0;i<n;i++) grid[i] = lines.get(i).toCharArray();
        return grid;
    }
    static char[][] copy(char[][] source) {
        int n = source.length;
        int m = source[0].length;
        char[][] destination = new char[n][m];
        for (int i=0;i<n;i++) for (int j=0;j<m;j++) destination[i][j] = source[i][j];
        return destination;
    }
    static void copy(char[][] source, char[][] destination) {
        int n = source.length;
        int m = source[0].length;
        for (int i=0;i<n;i++) for (int j=0;j<m;j++) destination[i][j] = source[i][j];
    }
    static boolean equal(char[][] source, char[][] destination) {
        int n = source.length;
        int m = source[0].length;
        for (int i=0;i<n;i++) for (int j=0;j<m;j++) {
            if (destination[i][j] != source[i][j]) return false;
        }
        return true;
    }
    static void tiltNS(char[][] grid, int sign) {
        int n = grid.length;
        int m = grid[0].length;
        for (int j=0;j<m;j++) {
            for (int i=(sign == -1 ? 0:n-1);sign == -1 ? i<n:i>=0;i -= sign) {
                if (grid[i][j] == 'O') {
                    int curI = i;
                    while (conditionSN(curI, n, sign) && grid[curI + sign][j] == '.') curI += sign;
                    if (curI != i) {
                        grid[i][j] = '.';
                        grid[curI][j] = 'O';
                    }
                }
            }
        }
    }
    static boolean conditionSN(int i, int n, int sign) {
        return sign == -1 ? i > 0 : i < n-1;
    }
    static boolean conditionWE(int j, int m, int sign) {
        return sign == -1 ? j > 0 : j < m-1;
    }
    static void tiltWE(char[][] grid, int sign) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i=0;i<n;i++) {
            for (int j=(sign == -1 ? 0 : m-1);(sign == -1 ? j<m:j>=0);j-=sign) {
                if (grid[i][j] == 'O') {
                    int curJ = j;
                    while (conditionWE(curJ, m, sign) && grid[i][curJ + sign] == '.') curJ += sign;
                    if (curJ != j) {
                        grid[i][j] = '.';
                        grid[i][curJ] = 'O';
                    }
                }
            }
        }
    }
    static void runCycle(char[][] grid) {
        tiltNS(grid, -1);
        tiltWE(grid, -1);
        tiltNS(grid, 1);
        tiltWE(grid, 1);
    }
    static long getLoad(char[][] grid) {
        long ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (grid[i][j] == 'O') {
                    ans += n - i;
                }
            }
        }
        return ans;
    }
    static void printGrid(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) out.print(grid[i][j]);
            out.println();
        }
    }

    static long part1(List<String> lines) {
        char[][] grid = readGrid(lines);
        tiltNS(grid, -1);
        return getLoad(grid);
    }

    static long part2(List<String> lines) {
        char[][] grid = readGrid(lines);
        boolean changed = true;
        int cnt = 1;
        while (changed && cnt <= 1000) {
            char[][] cgrid = copy(grid);
            runCycle(cgrid);
            changed = !equal(grid, cgrid);
            copy(cgrid, grid);
            cnt++;
        }
        return getLoad(grid);
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String readLine() {
            try {
                return reader.readLine();
            } catch (IOException ex) {
                return null;
            }
        }
    }
}
