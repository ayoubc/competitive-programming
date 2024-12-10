import java.io.*;
import java.util.*;
import java.util.stream.IntStream;


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
                if (line.isBlank()) {
                    break;
                }
                lines.add(line);
            } catch (Exception e) {
                break;
            }
        }
        out.println(part2(lines));
        out.close();
    }

    public static long part1(List<String> lines) {
        String file = lines.get(0);
        int id = 0;
        List<String> sb = new ArrayList<>();
        for (int i = 0; i < file.length(); i++) {
            int repeat = file.charAt(i) - '0';
            String s = ".";
            if (i % 2 == 0) {
                s = String.valueOf(id);
                id++;
            }
            for (int j = 0; j < repeat; j++) {
                sb.add(s);
            }
        }
        int i = 0;
        int j = sb.size() - 1;
        boolean looking = true;
        while (i < j) {
            if (looking) {
                if (sb.get(i).equals(".")) looking = false;
                else i++;
            } else {
                if (!sb.get(j).equals(".")) {
                    looking = true;
                    // swap
                    String c = sb.get(j);
                    sb.set(i, c);
                    sb.set(j, ".");
                } else j--;
            }
        }

        return IntStream.range(0, sb.size()).takeWhile(k->!sb.get(k).equals("."))
                .mapToLong(k -> Long.parseLong(sb.get(k)) * k)
                .reduce(Long::sum)
                .orElse(0); // 6200294120911
    }

    public static long part2(List<String> lines) {
        String file = lines.get(0);
        int id = 0;
        int curIndex = 0;
        Map<String, P> blocks = new HashMap<>();
        Map<Integer, Integer> free = new HashMap<>();
        List<String> unic = new ArrayList<>();
        for (int i = 0; i < file.length(); i++) {
            int repeat = file.charAt(i) - '0';
            if (i % 2 == 0) {
                String s = String.valueOf(id);
                blocks.put(s, new P(curIndex, repeat));
                unic.add(s);
                id++;
            } else {
                free.put(curIndex, repeat);
            }
            curIndex += repeat;
        }

        for (int ii = unic.size()-1; ii >= 0; ii--) {
            String s = unic.get(ii);
            P p = blocks.get(s);

            int idx = free.keySet().stream()
                    .filter(k -> k <= p.i && free.get(k) >= p.j)
                    .min(Integer::compare).orElse(-1);

            if (idx == -1) continue;
            int cnt = free.get(idx);
            free.remove(idx);
            if (cnt - p.j > 0) free.put(idx+p.j, cnt - p.j);
            blocks.put(s, new P(idx, p.j));
        }

        return blocks.entrySet().stream()
                .map(e -> Long.parseLong(e.getKey()) * (e.getValue().j * e.getValue().i + ((e.getValue().j - 1)*e.getValue().j)/2))
                .reduce(Long::sum).orElse(0L); // 6227018762750
    }
    record P(int i, int j) { }

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

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String readLine() throws IOException {
            return reader.readLine();
        }
    }
}