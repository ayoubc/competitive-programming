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
                if (line.isBlank()) {
                    break;
                }
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
        long ans = 0;
        for(String line : lines) {
            String[] parts = line.split(": ");
            long target = Long.parseLong(parts[0]);
            long[] nums = Arrays.stream(parts[1].split(" ")).mapToLong(Long::parseLong).toArray();
            if (isCorrect(nums.length-1, target, nums, "+")) ans += target;
        }
        return ans;
//        2437272016585
//        162987117690649
    }

    public static boolean isCorrect(int idx, long target, long[] nums, String lastOp) {
        if (idx < 0) {
            if ((lastOp.equals("*") && target == 1)
                    || ((lastOp.equals("+") || lastOp.equals("||")) && target == 0)) return true;
            return false;
        }
        boolean res = isCorrect(idx-1, target-nums[idx], nums, "+");
        if (target % nums[idx] == 0) res |= isCorrect(idx-1, target/nums[idx], nums, "*");
        if (isPart2) {
            int k = (int)Math.log10(nums[idx]) + 1;
            long ten = (long)Math.pow(10, k);
            if ((target - nums[idx]) % ten == 0) res |= isCorrect(idx-1, (target - nums[idx]) / ten, nums, "||");
        }
        return res;
    }

    public static char[][] getGrid(List<String> lines) {
        char[][] grid = new char[lines.size()][];
        int cnt = 0;
        for(String line: lines) grid[cnt++] = line.toCharArray();
        return grid;
    }

    public static long part2(List<String> lines) {
        isPart2 = true;
        return part1(lines);
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
