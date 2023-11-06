class Solution {
    static List<Integer>[] graph;
    static boolean[] vis;
    static boolean ans;
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        graph = new List[n];
        int[] ind = new int[n];
        vis = new boolean[n];

        for(int i=0;i<n;i++) {
            addEdge(i, leftChild[i]);
            addEdge(i, rightChild[i]);
            if (leftChild[i] != -1) ind[leftChild[i]]++;
            if (rightChild[i] != -1) ind[rightChild[i]]++;
        }
        int root = -1;
        for(int i=0;i<n;i++) {
            if (ind[i] == 0) {
                if (root != -1) return false;
                root = i;
            }
        }
        if (root == -1) return false;
        boolean ans =  dfs(root);
        for(int i=0;i<n;i++) ans &= vis[i];
        return ans;
    }
    public void addEdge(int i, int j) {
        if (graph[i] == null) graph[i] = new ArrayList<>();
        if (j == -1) return;
        graph[i].add(j);
    }
    public boolean dfs(int s) {
        if (vis[s]) return false;
        vis[s] = true;
        if (graph[s] == null) return true;
        for(Integer d: graph[s]) {
            if (!dfs(d)) return false;
        } 
        return true;
    }
}