import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[] arrows = {'>', 'v', '<', '^'};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;
    static boolean isPart2 = false;
    static char[][] grid;
    static int N;
    static int M;
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
        List<List<Integer>> locks = new ArrayList<>();
        List<List<Integer>> keys = new ArrayList<>();
        for(int i=0;i<lines.size();i+=8) {
            int firstLine = 0;
            List<Integer> nums = Arrays.asList(0, 0, 0, 0, 0);
            for(int j=0;j<5;j++) {
                for(int k=0;k<=6;k++) {
                    if (lines.get(k+i).charAt(j) == '#') {
                        nums.set(j, nums.get(j)+1);
                        if (k == 0) firstLine++;
                    }
                }
            }
            if(firstLine == 5) locks.add(nums);
            else keys.add(nums);
        }
        int ans = 0;
        for (List<Integer> lock: locks) {
            for (List<Integer> key: keys) {
                boolean fits = true;
                for(int i=0;i<lock.size();i++) {
                    if (lock.get(i)+key.get(i) - 2 > 5) {
                        fits = false;
                        break;
                    }
                }
                ans += fits ? 1 : 0;
            }
        }
        return ans;
    }

    public static long part2(List<String> lines) {

        return 0;
    }

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