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

    static char[][] grid;

    public static void main(String[] args){

        InputStream is;
        OutputStream os;
        try {
            is = new FileInputStream(".\\src\\ahc017\\in\\0036.txt");
            os = new FileOutputStream(".\\src\\ahc017\\out\\0036.txt");
        } catch (Exception e) {
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

        for (int i=0;i<M;i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            addEdge(u, v, w);
            edges[i] = new Edge(u, v, w, i);
        }
        for (int i=0;i<N;i++) {
            coords[i] = new Coord(in.nextInt(), in.nextInt(), i+1);
        }

        Strategy strategy = new Strategy2(N, M, D, K);
        int[] r = strategy.solve();
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
    static class Strategy2 extends Strategy {
        int[][] d;
        int[] sources;
        int center;
        Strategy2(int _N, int _M, int _D, int _K) {
            super(_N, _M, _D, _K);
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

                if (graph[p.u] == null) continue;
                for (P edge : graph[p.u]) {
                    int to = edge.u;
                    int len = edge.dist;
                    if (state != null) {
                        len = state.map[p.u][to] == day ? OO : edge.dist;
                    }

                    if (newD[p.u] + len < newD[to]) {
                        newD[to] = newD[p.u] + len;
                        pq.add(new P(newD[to], to));
                    }
                }
            }
            return newD;
        }
        public int getSource1() {
            return randomInt(1, N);
        }
        public int getSource() {
            Coord[] tmpCoords = coords.clone();
            Arrays.sort(tmpCoords);
            return tmpCoords[N/2].index;
        }
        public int[] getSources() {
            int[] res = new int[D >= 15 ? 5 : 15];
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
            center = getVertexCenter();
            res[4] = center;

            // pick another arbitrary ten if D < 10
            for (int i=5;i<res.length;i++) {
                while (true) {
                    int index = randomInt(1, N);
                    boolean ok = true;
                    for (int j=0;j<i;j++) {
                        if (res[j] == index) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) {
                        res[i] = index;
                        break;
                    }
                }
            }
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
        public int[] solve() {
//            source = getSource();
//            center = getVertexCenter();
            sources = getSources();
//            sources = new int[] {center};
            d = new int[sources.length][];
            for (int i=0;i<sources.length;i++) d[i] = getShortestDistancesAfterRepair(null, -1, sources[i]);

            double temp = 100000;
            double alpha = 0.95;

            // random state
            State currentState = new State();

            State best = new State(currentState.r);

            while (temp > 1) {
                State newState = getNewStateFrom(currentState);

                double currentF = currentState.getF();
                double newF = newState.getF();
                if (acceptance(currentF, newF, temp) > Math.random()) {
                    currentState = newState;
                }

                if (best.getF() > currentState.getF()) {
                    best = currentState;
                }

                temp *= alpha;
                //System.out.println(temp);
            }
            return best.r;
        }
        public class State {
            int[] r;
            int[][] map;
            double F = -1;
            State(int[] _r) {
                // copy from a state
                r = _r.clone();
            }
            State() {
                r = getInitialState();
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
            public int[] getInitialState() {
                int[] occ = new int[D+1];
                int[] res = new int[M];
                int limit = (int) Math.ceil(M/D);
                for (int i=0;i<M;i++) {
                    while (true) {
                        int d = randomInt(1, D);
                        if (occ[d] <= limit) {
                            res[i] = d;
                            occ[d] ++;
                            break;
                        }
                    }
                }
                return res;
            }
            public int[] getInitialState2() {
                int[] res = new int[M];
                return res;
            }
            public void mapEdgesWithDays() {
                map = new int[N+1][N+1];
                for (int i=0;i<M;i++) {
                    map[edges[i].u][edges[i].v] = r[i];
                    map[edges[i].v][edges[i].u] = r[i];
                }
            }
        }
        public State getNewStateFrom(State state) {
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
            for (int k=1;k<=D;k++) f[k] /= (4 * (N-1));
            for (int k=1;k<=D;k++) res += f[k];
            return 1000 * res / D;
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
            int[][] penalties = new int[D+1][N+1];
            int maxEdges = 2;
            for (int k=1;k<=D;k++) {
                int[] occ = new int[M+1];
                for (int i=0;i<M;i++) {
                    int u = edges[i].u;
                    int v = edges[i].v;
                    if (state.r[i] == k) {
                        if (occ[u] > maxEdges || occ[v] > maxEdges){
                            penalties[k][u] = OO;
                        }
                        occ[u] ++;
                        occ[v] ++;
                    }
                }
            }
            for (int i=0;i<M;i++) {
                int day = state.r[i];
                int u = edges[i].u;
                f[day] += edges[i].w + penalties[day][u];
            }
            double res = 0;
            for (int i=1;i<=D;i++) {
                for (int j=1;j<=D;j++) res += Math.abs(f[i]-f[j]);
            }
            return (res * 1000) / (D * (D - 1));
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
