class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1;
        int r = 10000001;
        
        int ans = -1;
        while(l < r) {
            int mid = (r + l) / 2;
            double h = isOK(dist, hour, mid);
            if (h <= hour) {
                ans = mid;
                r = mid;
                //System.out.println(h + " " + mid);
            }
            else l = mid + 1;
        }
        return ans;
    }
    private double isOK(int[] dist, double hour, int speed) {
        double h = 0.0;
        for(int i=0;i<dist.length-1;i++) {
            h += (dist[i] + speed - 1) / speed;
        }
        h += dist[dist.length-1] * 1.0d / speed;
        return h;
    }
}