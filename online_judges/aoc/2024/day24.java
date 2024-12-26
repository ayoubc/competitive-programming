import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[] arrows = {'>', 'v', '<', '^'};
    static int mod = (1 << 31) - 1;
    static Set<Integer>[] graph;
    static boolean isPart2 = false;
    static char[][] grid;
    static int N;
    static int M;
    static Set<String> sets;
    static int count;
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
        Map<String, Integer> wires = new HashMap<>();
        List<Gate> gates = new ArrayList<>();

        boolean startGates = false;
        for(String line : lines) {
            if (line.isEmpty()) startGates = true;
            else if (startGates) {
                String[] parts = line.split(" -> ");
                String[] ins = parts[0].split(" ");
                String a = ins[0];
                String b = ins[2];
                gates.add(new Gate(Arrays.asList(a, b), ins[1], parts[1]));
            }
            else {
                String[] parts = line.split(": ");
                wires.put(parts[0], Integer.parseInt(parts[1]));
            }
        }
        graph = constructGraph(gates);
        P p = solve(gates, wires);
        return p.z; //48806532300520
    }
    public static int calc(int a, int b, String op) {
        int res = 0;
        if (op.equals("AND")) res = (a & b);
        else if (op.equals("OR")) res = (a | b);
        else if (op.equals("XOR")) res = (a ^ b);
        return res;
    }
    public static void dfs(int v, boolean[] visited, List<Integer> order) {
        visited[v] = true;
        for (int u : graph[v]) {
            if (!visited[u])
                dfs(u, visited, order);
        }
        order.add(v);
    }

    public static long part2(List<String> lines) {
        Map<String, Integer> original = new HashMap<>();
        List<Gate> gates = new ArrayList<>();

        boolean startGates = false;
        for(String line : lines) {
            if (line.isEmpty()) startGates = true;
            else if (startGates) {
                String[] parts = line.split(" -> ");
                String[] ins = parts[0].split(" ");
                String a = ins[0];
                String b = ins[2];
                gates.add(new Gate(Arrays.asList(a, b), ins[1], parts[1]));
            }
            else {
                String[] parts = line.split(": ");
                original.put(parts[0], Integer.parseInt(parts[1]));
            }
        }
        graph = constructGraph(gates);
        Map<String, Integer> wires = new HashMap<>(original);
        P p = solve(gates, wires);
        long tot = p.x + p.y;
        long diff = p.z - tot;
        long X = p.x + diff/2;
        long Y = p.y + diff/2;
        Map<String, Integer> diffX = getDiff(X, "x", wires);
        Map<String, Integer> diffY = getDiff(Y, "y", wires);
        Set<String> zs = gates.stream().map(g->g.out).filter(s->s.startsWith("z")).collect(Collectors.toSet());
        Set<String> os = gates.stream().map(g->g.out).filter(s->!s.startsWith("z")).collect(Collectors.toSet());
        combinations(zs, zs, gates, original);
        return p.z; //48806532300520
    }
    public static Map<String, Integer> getDiff(long val, String chr, Map<String, Integer> wires) {
        Map<String, Integer> res = new HashMap<>();
        List<String> ins = wires.keySet().stream().filter(s->s.startsWith(chr)).sorted().toList();
        for(int i=0;i<ins.size();i++) {
            int c = (val & (1L << i)) == 0 ? 0 : 1;
            if (wires.get(ins.get(i)) != c) {
                res.put(ins.get(i), c);
            }
        }
        return res;
    }
    public static Set[] constructGraph(List<Gate> gates) {
        Map<String, Set<Integer>> map = new HashMap<>();
        for(int i=0;i<gates.size();i++) {
            Gate g = gates.get(i);
            String a = g.in.get(0);
            String b = g.in.get(1);
            Set<Integer> adjA = map.getOrDefault(a, new HashSet<>());
            Set<Integer> adjB = map.getOrDefault(b, new HashSet<>());
            adjA.add(i);
            adjB.add(i);
            map.put(a, adjA);
            map.put(b, adjB);
        }

        N = gates.size();
        Set[] grp = new Set[N];
        for (int i = 0; i < N; i++) {
            Gate g = gates.get(i);
            grp[i] = map.getOrDefault(g.out, new HashSet<>());
        }
        return grp;
    }
    public static List<Gate> copy(List<Gate> original) {
        List<Gate> copy = new ArrayList<>();
        for (Gate g : original) {
            copy.add(new Gate(g.in, g.op, g.out));
        }
        return copy;
    }
    public static void combinations(Set<String> x, Set<String> y, List<Gate> gates, Map<String, Integer> wires) {

        Queue<State> q = new LinkedList<>();
        q.add(new State(new ArrayList<>(), new HashSet<>()));
        while (!q.isEmpty()) {
            State curr = q.poll();
            if (curr.pairs.size() == 4) {
                // recompute x, y, z;
                // if x + y ==z break
                System.out.println("here");
                List<Gate> cpGates = new ArrayList<>();
                Map<String, Integer> cpWires = new HashMap<>(wires);
                Set<Integer> swaped = new HashSet<>();

                for(int i=0;i<gates.size();i++) {
                    Gate tmp = gates.get(i);
                    for(Pair pair: curr.pairs) {
                        String newOut = null;
                        if (tmp.out.equals(pair.x)) {
                            newOut = pair.y;

                        }
                        else if (tmp.out.equals(pair.y)) {
                            newOut = pair.x;
                        }
                        if(newOut != null) {
                            cpGates.add(new Gate(tmp.in, tmp.op, newOut));
                            break;
                        }
                        else cpGates.add(tmp);
                    }
                }

                P p = solve(cpGates, cpWires);
                if (p.x + p.y == p.z) {
                    System.out.println("found!!!!!");
                    break;
                }
            }
            for(String xx:x) {
                for(String yy:y) {
                    Set<String> seen = new HashSet<>(curr.seen);
                    if (!seen.contains(xx) && !seen.contains(yy)) {
                        List<Pair> pairs = new ArrayList<>(curr.pairs);
                        pairs.add(new Pair(xx, yy));
                        seen.add(xx);
                        seen.add(yy);
                        q.add(new State(pairs, seen));
                    }
                }
            }
        }
    }
    public static P solve(List<Gate> gates, Map<String, Integer> wires) {

        boolean[] visited = new boolean[graph.length];
        List<Integer> order = new ArrayList<>();
        for(int i=0;i<graph.length;i++) {
            if (!visited[i]) {
                dfs(i, visited, order);
            }
        }
        Collections.reverse(order);
        List<String> zs = new ArrayList<>();

        for(Integer idx: order) {
            Gate g = gates.get(idx);
            wires.put(g.out, calc(wires.get(g.in.get(0)), wires.get(g.in.get(1)), g.op));
            if (g.out.startsWith("z")) zs.add(g.out);

        }
        Collections.sort(zs);
        List<String> xs = wires.keySet().stream().filter(s->s.startsWith("x")).sorted().toList();
        List<String> ys = wires.keySet().stream().filter(s->s.startsWith("y")).sorted().toList();

        long z = compute(zs, wires);
        long x = compute(xs, wires);
        long y = compute(ys, wires);

//        long tot = x + y;
//        long diff = z - tot;
//        long X = x + diff/2;
//        long Y = y + diff/2;
        return new P(x, y, z);
    }
    public static long compute(List<String> ins, Map<String, Integer> wires) {
        long res = 0;
        for(int i=0;i<ins.size();i++) {
            if (wires.get(ins.get(i)) != 0) {
                res |= (1L << i);
            }
        }
        return res;
    }

    record Point(int i, int j) {}
    record Pair(String x, String y) {}
    record State(List<Pair> pairs, Set<String> seen) { }
    record P(long x, long y, long z) { }
    record Gate(List<String> in, String op, String out) {}
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