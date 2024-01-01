class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (p1, p2) -> {
            int c = Integer.compare(p1[0], p2[0]);
            if (c == 0) Integer.compare(p1[1], p2[1]);
            return c;
        });
        int ans = 0;
        for(int i=1;i<points.length;i++) {
            ans = Math.max(ans, points[i][0] - points[i-1][0]);
        }
        return ans;
    }
}