import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        long ans = 0;
        for (String line : lines) {
            Matcher m = Pattern.compile("mul\\(\\d+,\\d+\\)")
                    .matcher(line);
            while (m.find()) {
                String match = m.group();
                match = match.replace("mul", "").replace("(", "").replace(")", "");
                String[] nums = match.split(",");
                ans += Long.parseLong(nums[0]) * Long.parseLong(nums[1]);
            }
        }
        return ans;
    }

    public static long part2(List<String> lines) {
        long ans = 0;
        boolean enabled = true;
        for (String line : lines) {

            Matcher m = Pattern.compile("mul\\(\\d+,\\d+\\)|don't\\(\\)|do\\(\\)")
                    .matcher(line);
            while (m.find()) {
                String match = m.group();
                if (match.startsWith("do(")) enabled = true;

                else if (match.startsWith("don't")) enabled = false;
                else if (enabled) {
                    match = match.replace("mul", "").replace("(", "").replace(")", "");
                    String[] nums = match.split(",");
                    ans += Long.parseLong(nums[0]) * Long.parseLong(nums[1]);;
                }
                System.out.println(m.group() + " " +m.start()+ " ");
            }
        }
        return ans;
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
