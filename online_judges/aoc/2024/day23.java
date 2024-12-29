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
    static Map<String, List<String>> map;
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

    public static long part1(List<String> lines) {
        constructGraph(lines);

        Set<String> sets = new HashSet<>();
        for(String c:map.keySet()) {
            Stack<State> stk = new Stack<>();
            State init = new State(c, new HashSet<>());
            init.seen.add(c);
            stk.add(init);
            while (!stk.empty()) {
                State s = stk.pop();
                for(String nxt:map.get(s.p)) {
                    if (!s.seen.contains(nxt)) {
                        if (s.seen.size() + 1 <= 3) {
                            Set<String> seen = new HashSet<>(s.seen);
                            seen.add(nxt);
                            stk.add(new State(nxt, seen));
                        }
                    }
                    else if (nxt.equals(c) && s.seen.size() == 3) {
                        List<String> comp = new ArrayList<>(s.seen);
                        if (comp.stream().anyMatch(ss -> ss.startsWith("t"))) {
                            Collections.sort(comp);
                            sets.add(String.join("-", comp));
                        }
                    }
                }
            }
        }
        return sets.size(); // 926
    }

    public static String part2(List<String> lines) {
        constructGraph(lines);

        Set<String> largest = new HashSet<>();
        Set<String> vis = new HashSet<>();
        for(String c:map.keySet()) {
            if (vis.contains(c)) continue;

            Set<String> allConnected = new HashSet<>();
            allConnected.add(c);
            Queue<String> q = new LinkedList<>();
            q.add(c);

            while (!q.isEmpty()) {
                String cur = q.poll();

                for(String nxt:map.get(cur)) {
                    if (allConnected.contains(nxt)) continue;
                    // check if we can add nxt
                    boolean isOk = true;
                    for(String u:allConnected) {
                        if (!map.get(u).contains(nxt)) {
                            isOk = false;
                            break;
                        }
                    }
                    if (isOk) {
                        allConnected.add(nxt);
                        q.add(nxt);
                    }
                }
            }
            if (allConnected.size() >= largest.size()) {
                largest = allConnected;
            }
            vis.addAll(allConnected);
        }
        // az,ed,hz,it,ld,nh,pc,td,ty,ux,wc,yg,zz
        return String.join(",", largest.stream().sorted().toList());
    }
    public static void constructGraph(List<String> lines) {
        map = new HashMap<>();
        for(String line : lines) {
            String[] parts = line.split("-");
            List<String> a = map.getOrDefault(parts[0], new ArrayList<>());
            List<String> b = map.getOrDefault(parts[1], new ArrayList<>());
            a.add(parts[1]);
            b.add(parts[0]);
            map.put(parts[0], a);
            map.put(parts[1], b);
        }
    }
    record Point(int i, int j) {}
    record State(String p, Set<String> seen) { }
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