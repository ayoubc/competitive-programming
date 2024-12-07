import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static void main(String[] args){

        InputStream is;
        try {
            is = new FileInputStream(".\\src\\input\\in.txt");
        } catch (Exception e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);

        List<String> grid = new ArrayList<>();
        String line = null;
        while ((line = in.readLine()) != null) grid.add(line);

        out.println(part2(grid));
        out.close();
    }

    private static long part2(List<String> grid) {
        int r = grid.size();
        int c = grid.get(0).length();
        long ans = 0;
        G[][] gears = new G[r][c];
        for (int i=0;i<r;i++) {
            StringBuilder num = new StringBuilder();
            List<P> current = new ArrayList<>();
            for (int j=0;j<c;j++) {
                char d = grid.get(i).charAt(j);
                if (isDigit(d)) {
                    for (int k=0;k<8;k++) {
                        int I = i + dx[k];
                        int J = j + dy[k];
                        if (isValid(I, J, r, c) && isGear(grid.get(I).charAt(J))) {
                            if (gears[I][J] == null) gears[I][J] = new G();
                            if (gears[I][J].seen == 1) continue;
                            current.add(new P(I, J));
                            gears[I][J].seen = 1;
                        }
                    }
                    num.append(d);
                }
                else if (!num.isEmpty()){
                    long curNum = Long.parseLong(num.toString());
                    for (P p: current) {
                        gears[p.i][p.j].seen = 0;
                        if (gears[p.i][p.j].cnt == -1) continue;
                        if (gears[p.i][p.j].cnt > 2) {
                            gears[p.i][p.j].cnt = -1;
                            continue;
                        }
                        gears[p.i][p.j].cnt ++;
                        gears[p.i][p.j].p *= curNum;
                    }
                    current = new ArrayList<>();
                    num = new StringBuilder();
                }
            }
            if (!num.isEmpty()) {
                long curNum = Long.parseLong(num.toString());
                for (P p: current) {
                    gears[p.i][p.j].seen = 0;
                    if (gears[p.i][p.j].cnt == -1) continue;
                    if (gears[p.i][p.j].cnt > 2) {
                        gears[p.i][p.j].cnt = -1;
                        continue;
                    }
                    gears[p.i][p.j].cnt ++;
                    gears[p.i][p.j].p *= curNum;
                }
            }
        }
        for (G[] row: gears) {
            for (G g: row) {
                if (g == null) continue;
                ans += g.getRatio();
            }
        }

        return ans;
    }
    private static class P {
        int i;
        int j;
        public P(int _i, int _j) {
            i = _i;
            j = _j;
        }
    }
    private static class G {
        long p;
        int cnt;
        int seen;
        public G() {
            p = 1;
            cnt = 0;
            seen = 0;
        }
        public long getRatio() {
            return cnt == 2 ? p : 0L;
        }
    }

    private static boolean isSymbol(char c) {
        return c != '.' && (c < '0' || c > '9');
    }
    private static boolean isGear(char c) {
        return c == '*';
    }
    private static boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }
    private static boolean isValid(int i, int j, int r, int c) {
        return (i >= 0 && i < r) && (j >= 0 && j < c);
    }


    private static long part1(List<String> grid) {
        int r = grid.size();
        int c = grid.get(0).length();
        long ans = 0;

        for (int i=0;i<r;i++) {
            StringBuilder num = new StringBuilder();
            boolean ok = false;
            for (int j=0;j<c;j++) {
                char d = grid.get(i).charAt(j);
                if (isDigit(d)) {
                    if (!ok) {
                        for (int k=0;k<8;k++) {
                            int I = i + dx[k];
                            int J = j + dy[k];
                            if (isValid(I, J, r, c) && isSymbol(grid.get(I).charAt(J))) {
                                ok = true;
                                break;
                            }
                        }
                    }
                    num.append(d);
                }
                else {
                    if (ok) {
                        ans += Long.parseLong(num.toString());
                    }
                    ok = false;
                    num = new StringBuilder();
                }
            }
            if (!num.isEmpty() && ok) ans += Long.parseLong(num.toString());
        }

        return ans;
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
