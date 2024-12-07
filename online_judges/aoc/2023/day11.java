import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;
    static InputReader in;
    static PrintWriter out;
    static char[][] grid;
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
    static long getExpansion() {
        return isPart2 ? 1000000 : 2;
    }
    static long part1(List<String> lines) {
        char[][] grid = readGrid(lines);
        int n = grid.length;
        int m = grid[0].length;

        List<P> galaxies = new ArrayList<>();
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (grid[i][j] == '#') galaxies.add(new P(i, j));
            }
        }
        long ans = 0;
        List<Integer>[] emptyRowAndCol = getEmptyRowAndCol(grid);
        for (int i=0;i<galaxies.size();i++) {
            for (int j=i+1;j<galaxies.size();j++) {
                P g1 = galaxies.get(i);
                P g2 = galaxies.get(j);
                ans += g1.getDistFrom(g2);
                for (Integer r: emptyRowAndCol[0]) {
                    if (r >= Math.min(g1.i, g2.i) && r <= Math.max(g1.i, g2.i)) ans += getExpansion() - 1;
                }
                for (Integer c: emptyRowAndCol[1]) {
                    if (c >= Math.min(g1.j, g2.j) && c <= Math.max(g1.j, g2.j)) ans += getExpansion() - 1;
                }
            }
        }
        return ans;
    }
    static List<Integer>[] getEmptyRowAndCol(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        List<Integer>[] res = new List[2];
        for (int i=0;i<2;i++) res[i] = new ArrayList<>();

        for (int i=0;i<n;i++) {
            boolean isEmpty = true;
            for (int j=0;j<m;j++) {
                if (grid[i][j] != '.') {
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) res[0].add(i);
        }
        for (int j=0;j<m;j++) {
            boolean isEmpty = true;
            for (int i=0;i<n;i++) {
                if (grid[i][j] != '.') {
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) res[1].add(j);
        }
        return res;
    }
    static long part2(List<String> lines) {
        isPart2 = true;
        return part1(lines);
    }
    static class P {
        int i, j;

        public P(int i, int j) {
            this.i = i;
            this.j = j;
        }
        public int getDistFrom(P o) {
            return Math.abs(i - o.i) + Math.abs(j - o.j);
        }
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