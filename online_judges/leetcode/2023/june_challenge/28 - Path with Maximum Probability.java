class Solution {
    static List<Pair>[] graph;

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        graph = new List[n];
        for (int i=0;i<edges.length;i++) {
            addEdge(edges[i][0], edges[i][1], succProb[i]);
        }
        boolean[] vis = new boolean[n];
        double[] prob = new double[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(start, 1));
        prob[start] = 1;
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            if (p.u == end) return prob[p.u];

            if (vis[p.u]) continue;

            vis[p.u] = true;
            if (graph[p.u] == null) continue;
            for(Pair tmp: graph[p.u]) {
                double curp = p.p * tmp.p;
                if (curp > prob[tmp.u]) {
                    prob[tmp.u] = curp;
                    pq.add(new Pair(tmp.u, curp));
                }
            }
        }
        return 0;
    }
    static void addEdge(int a, int b, double p) {
        if (graph[a] == null) graph[a] = new ArrayList<>();
        if (graph[b] == null) graph[b] = new ArrayList<>();
        graph[a].add(new Pair(b, p));
        graph[b].add(new Pair(a, p));
    }
    static class Pair implements Comparable<Pair> {
        double p;
        int u;
        Pair(int u_, double p_) {
            u = u_;
            p = p_;
        }

        @Override
        public int compareTo(Pair o) {
            return Double.compare(p, o.p) * -1;
        }
    }
}