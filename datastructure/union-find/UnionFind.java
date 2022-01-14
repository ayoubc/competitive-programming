
public class UnionFind {
    public int[] ids;
    public int[] sz;
    public int n;

    public UnionFind(int n) {
        this.n = n;
        ids = new int[n+1];
        sz = new int[n+1];
        for (int i=0;i<=n;i++) {
            ids[i] = i;
            sz[i] = 1;
        }
    }

    public void union(int p, int q) {
        p = root(p);
        q = root(q);
        if (sz[p] <= sz[q]){
            ids[p] = q;
            sz[q] += sz[p];
        }
        else{
            ids[q] = p;
            sz[p] += sz[q];
        }
    }

    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    public int root(int x) {
        while (x != ids[x]) {
            ids[x] = ids[ids[x]];
            x = ids[x];
        }
        return x;
    }
}
