class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        int i = 0;
        int n = colors.length();
        while (i < n) {
            int j = i+1;
            int cnt = 0;
            int s = neededTime[i];
            int max = neededTime[i];
            while (j < n && colors.charAt(j) == colors.charAt(i)) {
                s += neededTime[j];
                cnt++;
                max = Math.max(max, neededTime[j]);
                j++;
            }
            
            if (cnt >= 1) {
                s -= max;
                ans += s;
            }
            i = j;
        }
        return ans;
    }
}