class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int n = points.length;
        Pair[] pairs = new Pair[n];
        for(int i=0;i<n;i++){
            pairs[i] = new Pair(points[i][0], points[i][1]);
        }
        
        Arrays.sort(pairs);
        
        int[][] ans = new int[K][2];
        for(int i=0;i<K;i++) ans[i] = new int[]{pairs[i].x, pairs[i].y};
        return ans;
    }
    
    class Pair implements Comparable<Pair>{
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int distance(){
            return this.x * this.x + this.y * this.y;
        }
        @Override
        public int compareTo(Pair o) {
            return this.distance() - o.distance();
        }
    }
}