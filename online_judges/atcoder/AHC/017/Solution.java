import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;
    static Edge[] edges;
    static int[] degree;
    static int[] orgDegree;
    static int OO = 1000000000;

    static char[][] grid;

    public static void main(String[] args){

        InputStream is;
        OutputStream os;
        try {
            is = new FileInputStream(".\\src\\ahc017\\in\\0000.txt");
            os = new FileOutputStream(".\\src\\ahc017\\out\\0000.txt");
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
        orgDegree = new int[N+1];

        for (int i=0;i<M;i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            addEdge(u, v, w);
            edges[i] = new Edge(u, v, w, i);
            orgDegree[u]++;
            orgDegree[v]++;
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
        graph[u].add(v);
        graph[v].add(u);
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
            return degree[u] + degree[v] + w;
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
        Strategy2(int _N, int _M, int _D, int _K) {
            super(_N, _M, _D, _K);
        }
        public void originalShortestDistance() {
            d = new int[N+1][N+1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    d[i][j] = i == j ? 0 : OO;

                }
            }
            for (int i=0;i<M;i++) {
                d[edges[i].u][edges[i].v] = edges[i].w;
                d[edges[i].v][edges[i].u] = edges[i].w;
            }
            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                    }
                }
            }
        }
        public int[][] getShortestDistancesAfterRepair(State state, int day) {
            int[][] newD = new int[N+1][N+1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    newD[i][j] = i == j ? 0 : OO;
                }
            }
            for (int i=0;i<M;i++) {
                int u = edges[i].u;
                int v = edges[i].v;
                int w = state.map[u][v] == day ? OO : edges[i].w;
                newD[u][v] = w;
                newD[v][u] = w;
            }
            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        newD[i][j] = Math.min(newD[i][j], newD[i][k] + newD[k][j]);
                    }
                }
            }
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    // in case we have wight bigger than OO;
                    newD[i][j] = Math.min(newD[i][j], OO);
                }
            }
            return newD;
        }
        public int[] solve() {
//            originalShortestDistance();

            double temp = 100000;
            double alpha = 0.99;

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
                for (int i=0;i<M;i++) {
                    while (true) {
                        int d = randomInt(1, D);
                        if (occ[d] < K) {
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
        public double fitness1(State state) {
            double[] f = new double[D+1];

            state.mapEdgesWithDays();

            for (int k=1;k<=D;k++) {
                int[][] newD = getShortestDistancesAfterRepair(state, k);
                for (int i=1;i<=N;i++){
                    for (int j=1;j<=N;j++){
                        f[k] += newD[i][j] - d[i][j];
                    }
                }
            }
            double res = 0.0;
            for (int k=1;k<=D;k++) f[k] /= N *(N-1);
            for (int k=1;k<=D;k++) res += f[k];
            return 1000 * res / D;
        }
        public double fitness(State state) {
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
