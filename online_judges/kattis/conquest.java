import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;
    static int[] visited;
    static int[] sizes;
    static int ans;

    static char[][] grid;

    public static void main(String[] args){

        InputStream is;
        try {
            is = new FileInputStream(".\\src\\input\\in.txt");
        } catch (Exception e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();
        sizes = new int[n+1];
        visited = new int[n+1];
        graph = new List[n+1];
        for (int i=0;i<m;i++) {
            addEdge(in.nextInt(), in.nextInt());
        }
        for (int i=1;i<=n;i++) sizes[i] = in.nextInt();

        ans = sizes[1];
        sizes[1] = 0;
        dfs(1);
        out.println(ans);
        out.close();
    }
    static public void dfs(int s) {
        visited[s]++;
        if (graph[s] == null) return;

        for(Integer v: graph[s]) {

            if (sizes[v] < ans && visited[v] <= 2) {
                ans += sizes[v];
                sizes[v] = 0;
                dfs(v);
            }
        }
    }
    static void addEdge(int i, int j) {
        if (graph[i] == null) graph[i] = new ArrayList<>();
        if (graph[j] == null) graph[j] = new ArrayList<>();
        graph[i].add(j);
        graph[j].add(i);
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