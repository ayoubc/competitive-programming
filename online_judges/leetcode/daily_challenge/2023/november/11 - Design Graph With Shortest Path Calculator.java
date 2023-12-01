class Graph {
    private List<Pair<Integer, Integer>>[] graph;
    private int nodes;
    Comparator<Pair<Integer, Integer>> comparator;
    public static final int OO = 1000000007;
    public Graph(int n, int[][] edges) {
        graph = new List[n];
        nodes = n;
        comparator = new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                return p1.getKey() - p2.getKey();
            }
        };
        for(int[] edge: edges) addEdge(edge);
    }
    
    public void addEdge(int[] edge) {
        int from = edge[0];
        int to = edge[1];
        int w = edge[2];
        if (graph[from] == null) graph[from] = new ArrayList<>();
        graph[from].add(new Pair<>(to, w));
    }
    
    public int shortestPath(int node1, int node2) {
        int[] dist = new int[nodes];
        boolean[] vis = new boolean[nodes];
        Arrays.fill(dist, OO);
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(comparator);
        dist[node1] = 0;
        pq.add(new Pair(0, node1));
        while(!pq.isEmpty()) {
            Pair<Integer, Integer> p = pq.poll();
            int w = p.getKey();
            int from = p.getValue();
            if (node2 == from) break;
            if (vis[from] || graph[from] == null) continue;
            vis[from] = true;
            for(Pair<Integer, Integer> pair: graph[from]) {
                if (dist[pair.getKey()] > pair.getValue() + dist[from]) {
                    dist[pair.getKey()] = pair.getValue() + dist[from];
                    pq.add(new Pair<>(dist[pair.getKey()], pair.getKey()));
                }
            }
        }
        return dist[node2] == OO ? -1 : dist[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */