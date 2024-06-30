class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] par1 = new int[n+1];
        int[] par2 = new int[n+1];
        for(int i=1;i<=n;i++) {
            par1[i] = i;
            par2[i] = i;
        }
        int m = edges.length;
        int used = 0;
        // start with type 3;
        for(int[] edge:edges) {
            if (edge[0] == 3) {
                int a = edge[1];
                int b = edge[2];
                boolean u1 = unionSets(a, b, par1);
                boolean u2 = unionSets(a, b, par2);
                if (u1 & u2) used++;
            }
        }
        for(int[] edge:edges) {
            if (edge[0] == 1) {
                int a = edge[1];
                int b = edge[2];
                boolean u1 = unionSets(a, b, par1);
                if (u1) used++;
            }
            else if(edge[0] == 2) {
                int a = edge[1];
                int b = edge[2];
                boolean u2 = unionSets(a, b, par2);
                if (u2) used++;
            }
        }

        int roots1 = 0;
        int roots2 = 0;
        for(int i=1;i<=n;i++) {
            if (par1[i] == i) roots1++;
            if (par2[i] == i) roots2++;
        }
        if (roots1 > 1 || roots2 > 1) return -1;
        return m - used;
    }
    private int findSet(int v, int[] parent) {
        if (v == parent[v]) return v;
        return parent[v] = findSet(parent[v], parent);
    }
    private boolean unionSets(int a, int b, int[] parent) {
        a = findSet(a, parent);
        b = findSet(b, parent);
        if (a != b) {
            parent[b] = a;
            return true;
        }
        return false;
    }
}