import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<P>[] graph;
    static Edge[] edges;
    static Coord[] coords;
    static int OO = 1000000000;
    static int[][] adjMatrix;

    static char[][] grid;

    public static void main(String[] args){

        InputStream is;
        OutputStream os;
        boolean debug = true;
        try {
            String filename = "0002.txt";
            is = new FileInputStream(".\\src\\ahc017\\in\\" + filename);
            os = new FileOutputStream(".\\src\\ahc017\\out\\" + filename);
        } catch (Exception e) {
            debug = false;
            is = System.in;
            os = System.out;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(os);

        int N = in.nextInt();
        int M = in.nextInt();
        int D = in.nextInt();
        int K = in.nextInt();
        graph = new List[N+1];
        edges = new Edge[M];
        coords = new Coord[N];
        adjMatrix = new int[N+1][N+1];
        for (int i=0;i<=N;i++) {
            for (int j=0;j<=N;j++) adjMatrix[i][j] = -1;
        }
        for (int i=0;i<M;i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            addEdge(u, v, w);
            edges[i] = new Edge(u, v, w, i);
            adjMatrix[u][v] = i;
            adjMatrix[v][u] = i;
        }
        for (int i=0;i<N;i++) {
            coords[i] = new Coord(in.nextInt(), in.nextInt(), i+1);
        }

        Strategy strategy = new Strategy2(N, M, D, K);
        long start = System.currentTimeMillis();
        int[] r = strategy.solve();
        long end = System.currentTimeMillis();

        if (debug) System.out.println("Computation Time:" + (end - start));
        for (int i=0;i<M;i++) {
            out.print(r[i] + " ");
        }
        out.close();
    }
    static void addEdge(int u, int v, int w) {
        if (graph[u] == null) graph[u] = new ArrayList<>();
        if (graph[v] == null) graph[v] = new ArrayList<>();
        graph[u].add(new P(w, v));
        graph[v].add(new P(w, u));
    }
    static int randomInt(int l, int r) {
        return (int)(Math.random()*(r-l+1)+l);
    }

    static class Strategy {
        int N, M, D, K;
        Strategy(int _N, int _M, int _D, int _K) {
            N = _N;
            M = _M;
            D = _D;
            K = _K;
        }
        public int[] solve(){
            return new int[M];
        }
    }
    static class Edge implements Comparable {
        int u, v, w;
        int index;
        boolean repaired = false;
        Edge(int _u, int _v, int _w, int i) {
            u = _u;
            v = _v;
            w = _w;
            index = i;
        }

        @Override
        public int compareTo(Object o) {
            Edge e = (Edge) o;
            if (e.score() == score()) return 0;
            if (e.score() < score()) return 1;
            return -1;
        }
        public void setRepaired() {
            repaired = true;
        }
        public int score() {
            return w;
        }
    }
    static class Coord implements Comparable {
        int x, y, index;
        Coord (int _x, int _y, int _index) {
            x = _x;
            y = _y;
            index = _index;
        }
        @Override
        public int compareTo(Object o) {
            Coord c = (Coord) o;
            if (c.x == x) {
                if (c.y == y) return 0;
                if (c.y < y) return 1;
                return -1;
            }
            if (c.x < x) return 1;
            return -1;
        }
        public long getDistanceFrom(Coord other) {
            // distance without sqrt
            return square(x - other.x) + square(y - other.y);
        }
    }
    public static long square(long x) {
        return x * x;
    }
    static class P implements Comparable {
        int dist, u;
        public P(int _d, int _u) {
            dist = _d;
            u = _u;
        }
        @Override
        public int compareTo(Object o) {
            P p = (P) o;
            if (p.dist == dist) return 0;
            if (p.dist < dist) return 1;
            return -1;
        }
    }
    static class Strategy1 extends Strategy {
        Strategy1(int _N, int _M, int _D, int _K) {
            super(_N, _M, _D, _K);
        }
        public int[] solve() {
            int[] occ = new int[D+1];
            int[] r = new int[M];
            for (int i=0;i<M;i++) {
                while (true) {
                    int d = randomInt(1, D);
                    if (occ[d] < K) {
                        r[i] = d;
                        occ[d] ++;
                        break;
                    }
                }
            }
            return r;
        }
    }
    static class Strategy3 extends Strategy {
        Strategy3(int _N, int _M, int _D, int _K) {
            super(_N, _M, _D, _K);
        }
        public int[] solve() {
            int[] res = new int[M];
            P[] days = new P[D];
            int[] occ = new int[D+1];
            for (int k=0;k<D;k++) days[k] = new P(0, k+1);
            Edge[] tmpEdges = edges.clone();
            Arrays.sort(tmpEdges, (e1, e2) -> {
                return Integer.compare(e1.w, e2.w) * -1;
            });
            for (int i=0;i<M;i++) {
                Arrays.sort(days, (d1, d2) -> {
                    return Integer.compare(d1.dist, d2.dist);
                });
                int edgeIndex = tmpEdges[i].index;
                for (int j=0;j<D;j++) {
                    int day = days[j].u;
                    if (occ[day] < K) {
                        occ[day] ++;
                        res[edgeIndex] = day;
                        days[j].dist += tmpEdges[i].w;
                        break;
                    }
                }
            }
            return res;
        }
    }
    static class Strategy2 extends Strategy {
        int[][] d;
        int[] sources;
        double T = 2000;
        double alpha = 0.85;
        int L = 100;
        double TL = 5850;
        double START = System.currentTimeMillis();

        boolean[] visited;

        int cc; // indicates number of vertices in same connected component
        boolean finished = false;

        int[] parent;
        int[] rank;

        Strategy2(int _N, int _M, int _D, int _K) {
            super(_N, _M, _D, _K);
        }
        public boolean isTLE() {
            return System.currentTimeMillis() - START > TL;
        }
        public double currentTime() {
            return System.currentTimeMillis();
        }
        public int[] solve() {
            parent = new int[N+1];
            rank = new int[N+1];
            sources = getSources();
            d = new int[sources.length][];
            for (int i=0;i<sources.length;i++) d[i] = getShortestDistancesAfterRepair(null, -1, sources[i]);
            visited = new boolean[N+1];
            double temp = T;

            // random state
            State currentState = new State();

            State best = new State(currentState);

            while (temp > 1 && !isTLE()) {
                for (int l=1;l<=L;l++) {
                    if (isTLE()) break;
                    State newState = getNewStateFrom(currentState);

                    double currentF = currentState.getF();
                    double newF = newState.getF();
                    if (acceptance(currentF, newF, temp) > Math.random()) {
                        currentState = newState;
                    }

                    if (best.getF() > currentState.getF()) {
                        best = currentState;
                    }
                }
                temp *= alpha;
            }
            return best.r;
        }

        public void dfs(int v, State state, int day) {
            visited[v] = true;
            cc++;
            for (P pair : graph[v]) {
                int to = pair.u;
                if(state.map[adjMatrix[v][to]] == day) continue;
                if (!visited[to]) dfs(to, state, day);
            }
        }
        public int[] getShortestDistancesAfterRepair(State state, int day, int source) {
            int[] newD = new int[N+1];
            for (int i=1;i<=N;i++) newD[i] = OO;
            newD[source] = 0;

            PriorityQueue<P> pq = new PriorityQueue<P>();

            pq.add(new P(0, source));
            while (!pq.isEmpty()) {
                P p = pq.poll();

                if (p.dist != newD[p.u])
                    continue;

                for (P edge : graph[p.u]) {
                    int to = edge.u;
                    int len = edge.dist;
                    if (state != null) {
                        len = state.map[adjMatrix[p.u][to]] == day ? OO : edge.dist;
                    }

                    if (newD[p.u] + len < newD[to]) {
                        newD[to] = newD[p.u] + len;
                        pq.add(new P(newD[to], to));
                    }
                }
            }
            return newD;
        }
        public int[] getSource1() {
            return new int[] {randomInt(1, N)};
        }
        public int[] getSources2() {
            Coord[] tmpCoords = coords.clone();
            Arrays.sort(tmpCoords);
            return new int[] {tmpCoords[N/2].index};
        }
        public int[] getSources4() {
            return new int[] {getVertexCenter()};
        }
        public int[] getSources3() {
            int[] res = new int[5];
            Coord[] tmpCoords = coords.clone();
            Arrays.sort(tmpCoords);
            res[0] = tmpCoords[0].index;
            res[1] = tmpCoords[N-1].index;
            Arrays.sort(tmpCoords, (c1, c2) -> {
                int c = Integer.compare(c1.y, c2.y);
                if (c == 0) return Integer.compare(c1.x, c2.x);
                return c;
            });
            res[2] = tmpCoords[0].index;
            res[3] = tmpCoords[N-1].index;
            res[4] = getVertexCenter();

            return res;
        }
        public int[] getSources() {
            // take the points with less total of weights
            P[] degree = new P[N];
            for (int i=0;i<N;i++) degree[i] = new P(0, i+1);
            for (int i=0;i<M;i++) {
                degree[edges[i].u-1].dist += edges[i].w;
                degree[edges[i].v-1].dist += edges[i].w;
            }
            Arrays.sort(degree, (p1, p2) -> Integer.compare(p1.dist, p2.dist));
            int[] res = new int[4];
            for (int i=0;i<res.length;i++) res[i] = degree[i].u;
            return res;
        }
        public int getVertexCenter() {
            long[][] dists = new long[N+1][N+1];
            for (int i=1;i<=N;i++) {
                for(int j=1;j<=N;j++) {
                    dists[i][j] = coords[i-1].getDistanceFrom(coords[j-1]);
                }
            }
            for (int i=1;i<=N;i++) Arrays.sort(dists[i]);
            long diff = Long.MAX_VALUE;
            int index = -1;
            for (int i=1;i<=N;i++) {
                long curDiff = 0;
                for (int j=2;j<=N;j++) curDiff += dists[i][j] - dists[i][j-1];
                if (curDiff < diff) {
                    index = i;
                    diff = curDiff;
                }
            }
            return index;
        }

        public class State {
            int[] r;

            // map each edge with day of repair
            int[] map;
            double F;
            State(int[] _r) {
                // copy from a state
                r = _r.clone();
                F = -1;
            }
            State(State state) {
                // copy from a state
                r = state.r.clone();
                F = -1;
            }
            State() {
                r = getInitialState();
                F = -1;
            }
            public void setF(double _F) {
                F = _F;
            }
            public double getF() {
                if (F == -1) {
                    F = fitness(this);
                }
                return F;
            }
            public int[] getInitialState2() {
                int[] occ = new int[D+1];
                int[] res = new int[M];
                int limit = (int) Math.ceil(M/D) + 1;
                for (int i=0;i<M;i++) {
                    while (true) {
                        int d = randomInt(1, D);
                        if (occ[d] < limit) {
                            res[i] = d;
                            occ[d] ++;
                            break;
                        }
                    }
                }
                return res;
            }
            public int[] getInitialState1() {
                int[] res = new int[M];
                Edge[] tmpEdges = edges.clone();
                Arrays.sort(tmpEdges, (e1, e2) -> {
                    return Integer.compare(e1.w, e2.w) * -1;
                });
                int j = 1;
                for (int i=0;i<M;i++) {
                    res[edges[i].index] = j;
                    j ++;
                    if (j > D) j = 1;
                }
                return res;
            }
            public int[] getInitialState() {
                Strategy s = new Strategy3(N, M, D, K);
                return s.solve();
            }
            public void mapEdgesWithDays() {
                map = new int[M];
                for (int i=0;i<M;i++) {
                    int u = edges[i].u;
                    int v = edges[i].v;
                    map[adjMatrix[u][v]] = r[i];
                }
            }
        }
        public State getNewStateFrom(State state) {
            // just swap two random (different) days of two edges
            State newState = new State(state.r);
            int index1 = randomInt(0, newState.r.length-1);
            int index2 = index1;
            while (newState.r[index1] == newState.r[index2])
                index2 = randomInt(0, newState.r.length-1);
            int c = newState.r[index1];
            newState.r[index1] = newState.r[index2];
            newState.r[index2] = c;
            return newState;
        }
        public State getNewStateFrom1(State state) {
            // shuffle the days of edges
            List<Integer> tmp = new ArrayList<>();
            for (int i=0;i<M;i++) tmp.add(state.r[i]);
            Collections.shuffle(tmp);
            int[] r = new int[M];
            for (int i=0;i<M;i++) r[i] = tmp.get(i);
            return new State(r);
        }

        public double acceptance(double currentF, double newF, double temp) {
            if(newF < currentF) return 1.0;
            return Math.exp((currentF - newF) / temp);
        }
        public double fitness(State state) {
            double[] f = new double[D+1];

            state.mapEdgesWithDays();
            for (int k=1;k<=D;k++) {
                int[][] newD = new int[sources.length][];
                for (int i=0;i<sources.length;i++) newD[i] = getShortestDistancesAfterRepair(state, k, sources[i]);

                for (int i=0;i<sources.length;i++){
                    for (int j=1;j<=N;j++){
                        f[k] += newD[i][j] - d[i][j];
                    }
                }
            }
            double res = 0.0;
            for (int k=1;k<=D;k++) f[k] /= (sources.length * (N-1));
            for (int k=1;k<=D;k++) res += f[k];
            return 1000 * res / D + fitness2(state) + fitness4(state);
        }
        public double fitness1(State state) {
            double[] f = new double[D+1];
            for (int i=0;i<M;i++) {
                f[state.r[i]] += edges[i].w;
            }
            double res = 0;
            for (int i=1;i<=D;i++) {
                for (int j=1;j<=D;j++) res += Math.abs(f[i]-f[j]);
            }
            return (res * 1000) / (D * (D - 1));
        }

        public double fitness2(State state) {
            double[] f = new double[D+1];
            int maxEdges = 3;
            for (int k=1;k<=D;k++) {
                int[] occ = new int[M+1];
                for (int i=0;i<M;i++) {
                    int u = edges[i].u;
                    int v = edges[i].v;
                    if (state.r[i] == k) {
                        if (occ[u] > maxEdges || occ[v] > maxEdges){
                            f[k] += OO;
                        }
                        occ[u] ++;
                        occ[v] ++;
                    }
                }
            }
            for (int i=0;i<M;i++) {
                f[state.r[i]] += edges[i].w;
            }
            double res = 0;
            for (int i=1;i<=D;i++) {
                for (int j=1;j<=D;j++) res += Math.abs(f[i]-f[j]);
            }
            return (res * 1000) / (D * (D - 1));
        }
        public double fitness3(State state) {
            double[] f = new double[D+1];
//            state.mapEdgesWithDays();
            for (int k=1;k<=D;k++) {
                List<Integer> connectedCompo = new ArrayList<>();
                for (int j=1;j<=N;j++) visited[j] = false;
                for (int j=1;j<=N;j++) {
                    if (!visited[j]) {

                        cc = 0;
                        dfs(j, state, k);
                        connectedCompo.add(cc);
                    }
                }
                long A = 0;
                double B = 0;

                // connectedCompo.size() is the number of connected components
                for (int ii=0;ii<connectedCompo.size();ii++) {
                    A += connectedCompo.get(ii);
                    B += square(connectedCompo.get(ii));
                }
                f[k] += (square(A) - B) / 2;
                f[k] *= OO;
                f[k] /= N * (N-1);
            }
            double res = 0;
            for (int i=1;i<=D;i++) {
                for (int j=1;j<=D;j++) {
                    res += Math.abs(f[i] - f[j]);
                }
            }
            return (res * 1000) / (D * (D - 1));
        }
        public double fitness4(State state) {
            double[] f = new double[D+1];
//            state.mapEdgesWithDays();
            for (int k=1;k<=D;k++) {
                f[k] += kruskalMST(state, k);
            }
            double res = 0;
            for (int i=1;i<=D;i++) {
                for (int j=1;j<=D;j++) res += Math.abs(f[i]-f[j]);
            }
            return (res * 1000) / (D * (D - 1));
        }
        public void makeSet(int v) {
            parent[v] = v;
            rank[v] = 0;
        }
        public int findSet(int v) {
            if (v == parent[v])
                return v;
            return parent[v] = findSet(parent[v]);
        }
        public void unionSets(int a, int b) {
            a = findSet(a);
            b = findSet(b);
            if (a != b) {
                if (rank[a] < rank[b]) {
                    int c = a;
                    a = b;
                    b = c;
                }
                parent[b] = a;
                if (rank[a] == rank[b])
                    rank[a]++;
            }
        }
        private double kruskalMST(State state, int day) {
            Edge[] tmpEdges = edges.clone();
            for (int i=0;i<M;i++) {
                if(state.map[i] == day) tmpEdges[i].w = OO;
            }

            for (int i = 1; i <= N; i++) makeSet(i);
            Arrays.sort(tmpEdges);
            double cost = 0;
            for (Edge e : tmpEdges) {
                if (findSet(e.u) != findSet(e.v)) {
                    cost += e.w;
                    unionSets(e.u, e.v);
                }
            }
            return cost;
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
