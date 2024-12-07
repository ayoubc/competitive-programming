import java.io.*;
import java.util.*;


public class Main {
    static InputReader in;
    static PrintWriter out;
    static boolean isPart2 = false;
    static int seek = 0;
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
        out.println(part1(lines));
        out.close();
    }
    static char[][] readPattern(List<String> lines) {
        List<String> res = new ArrayList<>();
        while (seek < lines.size()) {
            String line = lines.get(seek);
            seek++;
            if (line.isEmpty()) {
                break;
            }
            res.add(line);
        }
        int n = res.size();
        int m = res.get(0).length();
        char[][] grid = new char[n][m];
        for (int i=0;i<n;i++) grid[i] = res.get(i).toCharArray();
        return grid;
    }
    static long getColRefs(char[][] pattern) {
        int r = pattern.length;
        int c = pattern[0].length;
        long res = 0;
        for (int j=0;j<c;j++) {
            int left = j;
            int right = j+1;
            int len = Math.min(c - j - 1, j + 1);
            if (len == 0) continue;
            int diff = 0;
            while (left >= j - len + 1 && right <= j + len) {
                for (int i=0;i<r;i++) {
                    if (pattern[i][left] != pattern[i][right]) diff ++;
                }
                left--;
                right++;
            }
            if ((!isPart2 && diff == 0) || (isPart2 && diff == 1)) res += j + 1;
        }
        return res;
    }
    static long getRowRefs(char[][] pattern) {
        int r = pattern.length;
        int c = pattern[0].length;
        long res = 0;
        for (int i=0;i<r;i++) {
            int up = i;
            int down = i+1;
            int len = Math.min(r - i - 1, i + 1);
            if (len == 0) continue;
            int diff = 0;
            while (up >= i - len + 1 && down <= i + len) {
                for (int j=0;j<c;j++) {
                    if (pattern[up][j] != pattern[down][j]) diff ++;
                }
                up--;
                down++;
            }
            if ((!isPart2 && diff == 0) || (isPart2 && diff == 1)) res += (i + 1) * 100;
        }
        return res;
    }

    static long part1(List<String> lines) {
        seek = 0;
        long ans = 0;
        while (seek < lines.size()) {
            char[][] pattern = readPattern(lines);

            long colRefs = getColRefs(pattern);
            long rowRefs = getRowRefs(pattern);
            ans += colRefs + rowRefs;
        }
        return ans;
    }

    static long part2(List<String> lines) {
        seek = 0;
        isPart2 = true;
        return part1(lines);
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
