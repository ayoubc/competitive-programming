class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] p = new int[n];
        Arrays.fill(p, -1);
        for(int[] edge: edges) {
            p[edge[1]] = edge[0];
        }
        int ans = -1;
        for(int i=0;i<n;i++) {
            if (p[i] == -1) {
                if (ans == -1) ans = i;
                else {
                    ans = -1;
                    break;
                }
            }
        }
        return ans;
    }
}