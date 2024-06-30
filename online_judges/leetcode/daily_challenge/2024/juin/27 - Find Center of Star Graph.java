class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length+1;
        int[] degree = new int[n];
        for(int[] edge:edges) {
            degree[edge[0]-1]++;
            degree[edge[1]-1]++;
        }

        for(int i=0;i<n;i++) {
            if (degree[i] == n-1) return i+1;
        }
        return -1;
    }
}