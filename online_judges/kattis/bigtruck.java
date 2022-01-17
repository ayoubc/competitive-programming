
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

        int n = in.nextInt();
        graph = new List[n+1];
        for (int i=0;i<=n;i++) graph[i] = new ArrayList<>();

        int[] t = new int[n+1];
        for(int i=1;i<=n;i++) t[i] = in.nextInt();

        int m = in.nextInt();
        for(int i=0;i<m;i++){
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();

            graph[u].add(new Pair(v, w));
            graph[v].add(new Pair(u, w));
        }

        int[] dist = new int[n+1];
        int[] items = new int[n+1];
        for (int i=0;i<=n;i++) {
            dist[i] = OO;
            items[i] = 0;
        }

        PriorityQueue<Place> pq = new PriorityQueue<>();
        dist[1] = 0;
        items[1] = t[1];

        pq.add(new Place(items[1],0,1));
        while (!pq.isEmpty()) {
            Place place = pq.poll();
            int item = place.items , a = place.distance , b = place.node;

            for(int j=0;j<graph[b].size();j++){
                Pair p = graph[b].get(j);
                int e = p.v , w = p.w;
                if(dist[b] + w < dist[e] || (dist[b] + w == dist[e] && items[b] + t[e] > items[e])){
                    dist[e] = dist[b] + w;
                    items[e] = items[b] + t[e];
                    pq.add(new Place(items[e], dist[e],e));

                }
            }

        }
        if(dist[n] == OO) out.println("impossible");
        else out.println(dist[n] + " " + items[n]);

        out.close();
    }

    static class Pair {
        public int v, w;

        public Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static class Place implements Comparable{
        public int items,distance,node;


        public Place(int items, int distance, int node) {
            this.items = items;
            this.distance = distance;
            this.node = node;
        }

        @Override
        public int compareTo(Object o) {
            Place p = (Place)o;
            if (items == p.items) {
                if (distance < p.distance) return 1;
                if (distance == p.distance) return 0;
                return -1;
            }
            if (items < p.items) return -1;
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