class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] par = new List[n];
        for(int[] ed:edges) {
            int u = ed[0];
            int v = ed[1];
            if (par[v] == null) par[v] = new ArrayList<>();
            par[v].add(u);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++) {
            ans.add(getAncestors(i, par));
        }
        return ans;
    }
    private List<Integer> getAncestors(int s, List<Integer>[] pars) {
        Set<Integer> res = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()) {
            int u = q.poll();
            if (pars[u] == null) continue;
            for (int v : pars[u]) {
                if (res.contains(v)) continue;
                res.add(v);
                q.add(v);
            }
        }
        List<Integer> sorted = new ArrayList<>(res);
        Collections.sort(sorted);
        return sorted;
    }
}