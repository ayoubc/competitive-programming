import java.io.*;
import java.net.CookieHandler;
import java.util.*;


public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static InputReader in;
    static PrintWriter out;
    static int seek = 0;
    static int MAXN = 6;
    static Map<String, Integer> low = new HashMap<>();
    static Map<String, Integer> tin = new HashMap<>();
    static int timer;

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
    static private List<Edge> readEdges(List<String> lines) {
        List<Edge> res = new ArrayList<>();
        for (String line: lines) {
//            jqt: rhn xhk nvd
            String[] parts = line.split(" ");
            String a = parts[0].substring(0, parts[0].length()-1);
            for (int i=1;i<parts.length;i++) {
                res.add(new Edge(a, parts[i]));
            }
        }
        return res;
    }
    static private Map<String, Set<String>> readGraph1(List<Edge> edges) {
        Map<String, Set<String>> res = new HashMap<>();
        for (Edge edge: edges) {
            addEdge1(edge.from, edge.to, res);
            addEdge1(edge.to, edge.from, res);
        }
        return res;
    }
    static private Map<String, List<String>> readGraph(List<Edge> edges) {
        Map<String, List<String>> res = new HashMap<>();
        for (Edge edge: edges) {
            addEdge(edge.from, edge.to, res);
            addEdge(edge.to, edge.from, res);
        }
        return res;
    }
    static void dfs1(String s, Map<String, Set<String>> graph, Set<String> seen, List<Edge> removed) {
        seen.add(s);
        for (String next: graph.get(s)) {
            if (!seen.contains(next)) {
                boolean ok = true;
                for (Edge e: removed) {
                    if((e.from.equals(s) && e.to.equals(next)) || (e.to.equals(s) && e.from.equals(next))) {
                        ok = false;
                        break;
                    }
                }
                if(ok)  dfs1(next, graph, seen, removed);
            }
        }
    }
    static void dfs(String s, Map<String, List<String>> graph, Set<String> seen, List<Edge> removed) {
        seen.add(s);
        for (String next: graph.get(s)) {
            if (!seen.contains(next)) {
                boolean ok = true;
                for (Edge e: removed) {
                    if((e.from.equals(s) && e.to.equals(next)) || (e.to.equals(s) && e.from.equals(next))) {
                        ok = false;
                        break;
                    }
                }
                if(ok)  dfs(next, graph, seen, removed);
            }
        }
    }
    static void dfs_removed(String s, Map<String, List<String>> graph, Set<String> seen, List<Edge> removed, boolean canRemove) {
        seen.add(s);
        boolean isTaken = false;
        for (String next: graph.get(s)) {
            if (!seen.contains(next)) {
                if (canRemove && !isTaken && removed.size() < 3) {
                    removed.add(new Edge(s, next));
                    isTaken = false;
                }
                dfs_removed(next, graph, seen, removed, !canRemove);
            }
        }
    }
    static void dfs_bridges(String s, String p, Map<String, Set<String>> graph, Set<String> seen) {
        seen.add(s);
        tin.put(s, timer);
        low.put(s, timer);
        timer++;
        int children=0;
        for (String next: graph.get(s)) {
            if (next.equals(p)) continue;
            if (seen.contains(next)) {
                low.put(s, Math.min(low.get(s), tin.get(next)));
            }
            else {
                dfs_bridges(next, s, graph, seen);
                low.put(s, Math.min(low.get(s), low.get(next)));
                if (low.get(next) >= tin.get(s) && p != null) {
                    out.println(s);
                }
            }
        }
        if(p == null && children > 1)
            out.println(s);
    }
    static void addEdge1(String a, String b, Map<String, Set<String>> graph) {
        Set<String> connected = graph.getOrDefault(a, new HashSet<>());
        connected.add(b);
        graph.put(a, connected);
    }
    static void addEdge(String a, String b, Map<String, List<String>> graph) {
        List<String> connected = graph.getOrDefault(a, new ArrayList<>());
        connected.add(b);
        graph.put(a, connected);
    }
    static class Edge {
        String from, to;
        public Edge(String f, String t) {
            from = f;
            to = t;
        }
//        public int getScore(Map<String, Set<String>> graph) {
//            return graph.get(from).size() + graph.get(to).size();
//        }
    }

    static long part1(List<String> lines) {
        long ans = 0;
        List<Edge> edges = readEdges(lines);
        Map<String, List<String>> graph = readGraph(edges);
//        Collections.sort(edges, (e1, e2) -> {
//            return Integer.compare(e1.getScore(graph), e2.getScore(graph)) * -1;
//        });
        Set<String> vertices = graph.keySet();
//        for (String v : vertices) {
//            Collections.sort(graph.get(v), Comparator.comparingInt(e -> graph.get(e).size() * -1));
//        }

        for (String v: vertices) {
            // start v
            Set<String> seen = new HashSet<>();
            List<Edge> removed = new ArrayList<>();
            dfs_removed(v, graph, seen, removed, true);

            seen = new HashSet<>();
            List<Integer> sizes = new ArrayList<>();
            for (String u: vertices) {
                if(seen.contains(u)) continue;
                dfs(u, graph, seen, removed);
                if (sizes.isEmpty()) sizes.add(seen.size());
                else sizes.add(seen.size() - sizes.get(sizes.size()-1));
            }
            if (sizes.size() >= 2) {
                ans = sizes.get(0) * sizes.get(1);
            }

        }
        return ans;
    }

    static long part2(List<String> lines) {
        return 0;
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