class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> occ = new HashMap<>();
        int cnt = 0;
        int ans = 0;
        occ.put(0, 1);
        for(int num:nums) {
            cnt += num % 2;
            int x = cnt - k;
            if (x >= 0) {
                ans += occ.getOrDefault(x, 0);
            }
            occ.put(cnt, occ.getOrDefault(cnt, 0)+1);
        }
        return ans;
    }
}