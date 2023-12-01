class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        List<M> ms = new ArrayList();
        int n = dist.length;
        for(int i=0;i<n;i++) {
            ms.add(new M(dist[i], speed[i]));
        }
        Collections.sort(ms);
        int ans = 0;
        for(M m : ms) {
            if (ans >= m.time) break;
            ans ++;
        }
        return ans;
    }
    private class M implements Comparable<M> {
        int dist, speed;
        int time;
        M (int d, int s) {
            dist = d;
            speed = s;
            time = (dist + speed - 1) / speed;
        }
        @Override
        public int compareTo(M other) {
            int c = Integer.compare(time, other.time);
            return c;
        }
    }
}