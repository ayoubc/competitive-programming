class Solution {
    List<Integer>[] graph;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        graph = new List[n];
        boolean[] vis = new boolean[n];
        for(int[] p:edges){
            addEdge(p[0], p[1]);
        }
        return valid(source, destination, vis);
    }
    private void addEdge(int a, int b) {
        if (graph[a] == null) graph[a] = new ArrayList<>();
        if (graph[b] == null) graph[b] = new ArrayList<>();
        graph[a].add(b);
        graph[b].add(a);
    }

    private boolean valid(int s, int d, boolean[] vis) {
        if (s == d) return true;
        vis[s] = true;
        if (graph[s] == null) return false;
        boolean reached = false;
        for (int v:graph[s]) {
            if (!vis[v]) reached |= valid(v, d, vis);
        }
        return reached;
    }
}