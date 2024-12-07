import java.io.*;
import java.util.*;



public class Main {
    static int[] dx = {0, 1, 0, -1, 1,1,-1,-1};
    static int[] dy = {1, 0, -1, 0, 1,-1,-1,1};
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
        List<String> ordering = new ArrayList<>();
        List<String> updates = new ArrayList<>();
        int cnt = 0;
        while(true) {
            try{
                String line = in.readLine();
                if (line.isBlank()) {
                    if (cnt == 1) break;
                    cnt++;
                    continue;
                }
                if (cnt == 0) ordering.add(line);
                else updates.add(line);
            }
            catch (Exception e) {
                break;
            }
        }
        out.println(part2(ordering, updates));
        out.close();
    }

    public static long part1(List<String> ordering, List<String> updates) {
        Map<String, Set<String>> order = getOrdering(ordering);
        int ans = 0;
        for(String line:updates) {
            String[] parts = line.split(",");
            if (isCorrect(parts, order)) {
                ans += Integer.parseInt(parts[parts.length/2]);
            }
        }
        return ans;
    }

    public static Map<String, Set<String>> getOrdering(List<String> ordering) {
        Map<String, Set<String>> order = new HashMap<>();
        for(String line:ordering) {
            String[] parts = line.split("\\|");
            order.putIfAbsent(parts[0], new HashSet<>());
            order.get(parts[0]).add(parts[1]);
        }
        return order;
    }

    public static boolean isCorrect(String[] arr, Map<String, Set<String>> order) {
        for(int i=0;i<arr.length;i++) {
            boolean ok = true;
            for(int j=i+1;j<arr.length;j++) {
                if (order.get(arr[j]) != null && order.get(arr[j]).contains(arr[i])) {
                    ok = false;
                    break;
                }
            }
            if (!ok) return false;
        }
        return true;
    }


    public static long part2(List<String> ordering, List<String> updates) {
        Map<String, Set<String>> order = getOrdering(ordering);
        int ans = 0;
        for(String line:updates) {
            String[] parts = line.split(",");
            if (isCorrect(parts, order)) continue;
            Arrays.sort(parts, (s1, s2) -> {
                if (order.get(s2) != null && order.get(s2).contains(s1)) return 1;
                if (order.get(s1) != null && order.get(s1).contains(s2)) return -1;
                return 0;
            });
            ans += Integer.parseInt(parts[parts.length/2]);
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
