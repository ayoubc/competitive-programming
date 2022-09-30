import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;

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
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            char[] s = in.next().toCharArray();
            List<Integer>[] g = new List[2 * n + 1];
            Stack<Integer> st = new Stack<>();
            Stack<P> lefts = new Stack<>();

            int curLevel = 1;
            for (int i=0;i < 2 * n; i++) {
                if (st.isEmpty()) {
                    st.push(i);
                    curLevel = 1;
                    if (lefts.isEmpty()) lefts.push(new P(i, curLevel));
                }
                else {
                    int j = st.peek();
                    if(s[j] == '(' && s[i] == ')') {
                        addEdge(i, j, g);
                        st.pop();
                        while (lefts.peek().level > curLevel) lefts.pop();

                        if (lefts.peek().index != j) addEdge(i, lefts.peek().index, g);

                        curLevel--;
                    }
                    else {
                        st.push(i);
                        curLevel++;
                        if (lefts.peek().level != curLevel) lefts.push(new P(i, curLevel));
                    }
                }
            }

            out.println(cc(g));
        }
        out.close();
    }
    public static int cc(List<Integer>[] graph) {
        int cnt = 0;
        boolean[] vis = new boolean[graph.length+1];
        for (int i=1;i<graph.length;i++) {
            if (!vis[i]) {
                cnt ++;
                dfs(i, vis, graph);
            }
        }
        return cnt;
    }
    public static void dfs(int s, boolean[] vis, List<Integer>[] graph) {
        vis[s] = true;
        for (Integer i:graph[s]) {
            if (!vis[i]) dfs(i, vis, graph);
        }
    }
    public static void addEdge(int i, int j, List<Integer>[] graph) {
        i++; j++;
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
