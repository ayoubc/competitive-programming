class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        
        int l = candidates;
        int r = n - candidates - 1;
        
        PriorityQueue<Pair> left = new PriorityQueue<Pair>();
        PriorityQueue<Pair> right = new PriorityQueue<Pair>();
        for(int i=0;i<n;i++) {
            if (i <= candidates-1) left.add(new Pair(i, costs[i]));
            else if (i >= n - candidates) right.add(new Pair(i, costs[i]));
        }
         
        boolean[] vis = new boolean[n];
        long ans = 0;
        for(int i=0;i<k;i++) {
            Pair pl = left.peek();
            Pair pr = right.peek();
            while (pl != null && vis[pl.i]) {
                //System.out.println("l->" + pl.i + " " + pl.v);
                left.poll();
                if (l < n) {
                    left.add(new Pair(l, costs[l]));
                    l++;
                }
                pl = left.peek();
            }
            while (pr != null && vis[pr.i]) {
                //System.out.println("r->" + pr.i + " " + pr.v);
                right.poll();
                if (r >= 0) {
                    right.add(new Pair(r, costs[r]));
                    r--;
                }
                pr = right.peek();
            }
            if (pr == null || pl.v <= pr.v) {
                left.poll();
                ans += 1l * pl.v;
                vis[pl.i] = true;
                if (l < n) {
                    left.add(new Pair(l, costs[l]));
                    l++;
                }
            }
            else if (pr != null && pl.v > pr.v) {
                right.poll();
                ans += 1l * pr.v;
                vis[pr.i] = true;
                if (r >= 0) {
                    right.add(new Pair(r, costs[r]));
                    r--;
                }
            }
            //else System.out.println("klskdf");
        }
        
        return ans;
    }

    static class Pair implements Comparable<Pair> {
        int i, v;
        Pair(int i, int v) {
            this.i = i;
            this.v = v;
        }

        @Override
        public int compareTo(Pair p) {
            int c = Integer.compare(this.v, p.v);
            if (c == 0) Integer.compare(this.i, p.i);
            return c;
        }
    }
}