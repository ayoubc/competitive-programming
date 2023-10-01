class Solution {
    static int[] parent;
    static int[] rank;
    static List<P> edges;
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        edges = new ArrayList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if (i == j) continue;
                edges.add(new P(i, j, dist(points[i], points[j])));
            }
        }
        
        parent = new int[n];

        for (int i = 0; i < n; i++) parent[i] = i;

        Collections.sort(edges, (P p1, P p2) -> {
            return Integer.compare(p1.w, p2.w);
        });
        int cost = 0;
        for (P e : edges) {
            if (findSet(e.u) != findSet(e.v)) {
                cost += e.w;
                unionSets(e.u, e.v);
            }
        }
        return cost;
    }
    
    private int dist(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    static class P {
        int u, v, w;
        public P(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

    }

    private void unionSets(int a, int b) {
        a = findSet(a);
        b = findSet(b);
        parent[b] = a;
        
    }
    
    private int findSet(int v) {
        if (v == parent[v])
            return v;
        return parent[v] = findSet(parent[v]);
    }
}