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
    static long[] dp;
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
        out.println(part2(lines));
        out.close();
    }

    public static String part1(List<String> lines) {
        long[] val = new long[8];
        for(int i=0;i<=3;i++) val[i] = i;
        for(int i=0;i<3;i++) {
            val[i+4] = Integer.parseInt(lines.get(i).split(": ")[1]);
        }
        List<Integer> program = Arrays.stream(lines.get(4).split(" ")[1].split(","))
                .map(Integer::parseInt).toList();

        return String.join(",", compute(program, val).stream().map(String::valueOf).toList());
    }

    public static List<Integer> compute(List<Integer> program, long[] vals) {
        List<Integer> ans = new ArrayList<>();
        long[] val = vals.clone();
        int i = 0;
        while (i<program.size()) {
            int opcode = program.get(i);
            if (opcode == 0) {
                val[4] = val[4] / (1L << val[program.get(i+1)]);
                i+=2;
            }
            if (opcode == 1) {
                val[5] ^= program.get(i+1);
                i+=2;
            }
            if (opcode == 2) {
                val[5] = val[program.get(i+1)]%8;
                i+=2;
            }
            if (opcode == 3) {
                if (val[4] != 0) {
                    i = program.get(i+1);
                }
                else i+=2;
            }
            if (opcode == 4) {
                val[5] ^= val[6];
                i+=2;
            }
            if (opcode == 5) {
                int v = (int)(val[program.get(i+1)]%8);
                ans.add(v);
                i+=2;
            }
            if (opcode == 6) {
                val[5] = val[4] / (1L << val[program.get(i+1)]);
                i+=2;
            }
            if (opcode == 7) {
                val[6] = val[4] / (1L << val[program.get(i+1)]);
                i+=2;
            }
        }
        return ans;
    }
    public static long part2(List<String> lines) {
        long[] val = new long[8];
        for(int i=0;i<=3;i++) val[i] = i;
        for(int i=0;i<3;i++) {
            val[i+4] = Integer.parseInt(lines.get(i).split(": ")[1]);
        }
        List<Integer> program = Arrays.stream(lines.get(4).split(" ")[1].split(","))
                .map(Integer::parseInt).toList();

        long l = 0;
        long r = Long.MAX_VALUE;
        long A = 0;
        while (l<r) {
            long mid = l + (r-l)/2;
            val[4] = mid;
            List<Integer> newP = compute(program, val);
            if (newP.size() < program.size()) l = mid+1;
            else if (newP.size() > program.size()) r = mid-1;
            else {
//                boolean ok = true;
//                for(int i=0;i<program.size();i++) {
//                    if (newP.get(i) != program.get(i)) {
//                        ok = false;
//                        break;
//                    }
//                }
//                if (ok) {
//                    A = mid;
//                    r = mid-1;
//                }
//                else l = mid;
                A = mid;
                r = mid -1 ;
            }
        }
        return A;
    }

    record P(int i, int j, int dst) { }

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