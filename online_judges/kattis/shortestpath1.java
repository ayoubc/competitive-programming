
import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int OO = (1 << 31) - 1;
    static List<Pair>[] graph;

    static char[][] grid;


    public static void main(String[] args){
        InputStream is;
        try {
            is = new FileInputStream(".\\src\\in.txt");
        } catch (FileNotFoundException e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);

        StringBuilder sb = new StringBuilder();
        while (true) {
            try{
                int n = in.nextInt();
                int m = in.nextInt();
                int q = in.nextInt();
                int s = in.nextInt();
                if (n == 0) break;
                graph = new List[n];
                for(int i=0;i <n;i++) graph[i] = new ArrayList<>();

                for(int i=0;i<m;i++){
                    int u = in.nextInt();
                    int v = in.nextInt();
                    int w = in.nextInt();


                    graph[u].add(new Pair(w, v));
                }

                int[] dist = new int[n];
                for (int i=0;i<n;i++) dist[i] = OO;

                dist[s] = 0;
                PriorityQueue<Pair> pq = new PriorityQueue<>();
                pq.add(new Pair(0, s));
                while (!pq.isEmpty()) {
                    Pair p = pq.poll();
                    for(int i=0;i<graph[p.v].size();i++){
                        Pair tmp = graph[p.v].get(i);

                        if(dist[tmp.v] > p.w + tmp.w){
                            dist[tmp.v] = p.w + tmp.w;
                            pq.add(new Pair(dist[tmp.v], tmp.v));

                        }
                    }

                }
                while(q-- > 0){
                    int u = in.nextInt();

                    if(dist[u]==OO) sb.append("Impossible\n");
                    else sb.append(dist[u] + "\n");
                }
                sb.append("\n");
            } catch (NullPointerException e) {break;}
        }

        out.print(sb);
        out.close();
    }

    static class Pair implements Comparable{
        public int v, w;

        public Pair(int w, int v) {
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Object o) {
            Pair p = (Pair)o;
            if (w == p.w) return 0;
            if (w < p.w) return -1;
            return 1;
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
    }
}