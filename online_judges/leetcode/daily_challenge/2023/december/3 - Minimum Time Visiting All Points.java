class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        
        for(int i=1;i<points.length;i++) {
            int[] point1 = points[i - 1];
            int[] point2 = points[i];
            int dx = Math.abs(point1[0] - point2[0]);
            int dy = Math.abs(point1[1] - point2[1]);
            ans += Math.min(dx, dy) + Math.abs(dx - dy);
        }
        return ans;
    }
}