import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[] arrows = {'>', 'v', '<', '^'};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;
    static boolean isPart2 = false;
    static char[][] grid;
    static InputReader in;
    static PrintWriter out;

    public static void main(String[] args) {

        InputStream is;
        try {
            is = new FileInputStream(".\\src\\input\\in.txt");
        } catch (Exception e) {
            is = System.in;
        }
        in = new InputReader(is);
        out = new PrintWriter(System.out);
        List<String> lines = new ArrayList<>();

        while (true) {
            try {
                String line = in.readLine();
                if (line == null) break;
                lines.add(line);
            } catch (Exception e) {
                break;
            }
        }
        out.println(part1(lines));
        out.close();
    }

    public static long part1(List<String> lines) {
        List<String> map = new ArrayList<>();
        List<String> moves = new ArrayList<>();
        boolean isMove = false;
        for (String line : lines) {
            if (line.isEmpty()) {
                isMove = true;
                continue;
            }
            if (isMove) moves.add(line);
            else map.add(line);
        }
        grid = getGrid(map);
        int starti = -1;
        int startj = -1;
        loop:
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '@') {
                    starti = i;
                    startj = j;
                    break loop;
                }
            }
        }

        int si = starti;
        int sj = startj;
        grid[si][sj] = '.';
        for (String move : moves) {
            for (int i=0;i<move.length();i++) {
                char c = move.charAt(i);
                int k = getDirIdx(c);

                int ii = dx[k] + si;
                int jj = dy[k] + sj;
                if (grid[ii][jj] == '.') {
                    si = ii;
                    sj = jj;
                }
                else if (grid[ii][jj] == 'O') {
                    // need to move boxes all the way until blocked
                    int curi = ii;
                    int curj = jj;
                    int o = 0;
                    while (grid[curi][curj] == 'O') {
                        o++;
                        curi += dx[k];
                        curj += dy[k];
                    }
                    int sii = si;
                    int sjj = sj;
                    while (curi != si || curj != sj) {
                        if (o == 0) {
                            sii = curi;
                            sjj = curj;
                        }
                        if (grid[curi][curj] != '#') {
                            if (o > 0) grid[curi][curj] = 'O';
                            else grid[curi][curj] = '.';
                            o--;
                        }
                        curi += dx[k] * -1;
                        curj += dy[k] * -1;
                    }

                    si = sii;
                    sj = sjj;
                }
            }
        }
        grid[si][sj] = '@';
        long ans = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if (grid[i][j] == 'O') ans += i * 100 + j;
            }
        }
        return ans; // 1421727
    }


    public static long part2(List<String> lines) {
        List<String> map = new ArrayList<>();
        List<String> moves = new ArrayList<>();
        boolean isMove = false;
        for (String line : lines) {
            if (line.isEmpty()) {
                isMove = true;
                continue;
            }
            if (isMove) moves.add(line);
            else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (c == '@') sb.append(".").append(c);
                    else if (c == 'O') sb.append("[]");
                    else sb.append(c).append(c);
                }
                map.add(sb.toString());
            }
        }
        grid = getGrid(map);
        int starti = -1;
        int startj = -1;
        loop:
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '@') {
                    starti = i;
                    startj = j;
                    break loop;
                }
            }
        }

        int si = starti;
        int sj = startj;
        grid[si][sj] = '.';
        for (String move : moves) {
            for (int i=0;i<move.length();i++) {
                char c = move.charAt(i);
                int k = getDirIdx(c);

                int ii = dx[k] + si;
                int jj = dy[k] + sj;
                if (grid[ii][jj] == '.') {
                    si = ii;
                    sj = jj;
                }
                else if (grid[ii][jj] == 'O') {
                    // need to move boxes all the way until blocked
                    int curi = ii;
                    int curj = jj;
                    int o = 0;
                    while (grid[curi][curj] == 'O') {
                        o++;
                        curi += dx[k];
                        curj += dy[k];
                    }
                    int sii = si;
                    int sjj = sj;
                    while (curi != si || curj != sj) {
                        if (o == 0) {
                            sii = curi;
                            sjj = curj;
                        }
                        if (grid[curi][curj] != '#') {
                            if (o > 0) grid[curi][curj] = 'O';
                            else grid[curi][curj] = '.';
                            o--;
                        }
                        curi += dx[k] * -1;
                        curj += dy[k] * -1;
                    }

                    si = sii;
                    sj = sjj;
                }
            }
        }
        long ans = 0;

        return ans; // 6227018762750
    }

    public static char[][] getGrid(List<String> lines) {
        char[][] grid = new char[lines.size()][];
        int cnt = 0;
        for (String line : lines) grid[cnt++] = line.toCharArray();
        return grid;
    }
    public static int getDirIdx(char c) {
        for (int i = 0; i < 4; i++) {
            if (arrows[i] == c) return i;
        }
        return -1;
    }
    public static void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    record P(int i, int j) { }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String readLine() throws IOException {
            return reader.readLine();
        }
    }
}