import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
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
        int ans = 0;
        for (String line : lines) {
            List<Integer> prts = Arrays.stream(line.split("\\s+")).map(Integer::parseInt).toList();
            if (isSafe(prts)) ans++;
        }
        return ans;
    }

    public static long part2(List<String> lines) {
        int ans = 0;
        for (String line : lines) {
            //Integer[] prts = Arrays.stream(line.split("\\s+")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
            String[] prts = line.split("\\s+");
            for (int i=0;i<prts.length;i++) {
                List<Integer> tmp = new ArrayList<>();
                for (int j=0;j<prts.length;j++) {
                    if (i == j) continue;
                    tmp.add(Integer.parseInt(prts[j]));
                }
                if (isSafe(tmp)) {
                    ans ++;
                    break;
                }
            }
        }
        return ans;
    }
    public static boolean isSafe(List<Integer> levels) {
        int sign = Integer.compare(levels.get(1), levels.get(0));
        boolean ok = sign != 0;
        for (int i = 1;i < levels.size();i++) {
            int a = levels.get(i);
            int b = levels.get(i-1);
            if (a == b || !(Math.abs(a-b) >= 1 && Math.abs(a-b) <= 3 && Integer.compare(a,b) == sign)) {
                ok = false;
                break;
            }
        }
        return ok;
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
