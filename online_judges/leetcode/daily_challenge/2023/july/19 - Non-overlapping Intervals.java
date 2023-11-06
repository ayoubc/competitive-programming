class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a1, a2) -> {
            int c = Integer.compare(a1[0], a2[0]);
            if (c == 0) c = Integer.compare(a1[1], a2[1]);
            return c;
        });
        
        int l = -1;
        int cnt = 0;
        for(int i=0;i<intervals.length;i++) {
            if (i == 0) l = intervals[i][1];
            else if (intervals[i][0] >= l) {
                l = intervals[i][1];
            }
            else if (intervals[i][0] < l) {
                cnt++;
                l = Math.min(l, intervals[i][1]);
            }
        }
        return cnt;
    }
}