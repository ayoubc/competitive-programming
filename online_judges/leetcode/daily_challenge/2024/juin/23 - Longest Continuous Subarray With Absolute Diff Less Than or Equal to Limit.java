class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int i = 0;

        int ans = 0;
        TreeMap<Integer, Integer> occ = new TreeMap<>();
        for(int j=0;j<n;j++) {
            occ.put(nums[j], occ.getOrDefault(nums[j], 0) + 1);
            while (occ.lastKey() - occ.firstKey() > limit) {
                int cnt = occ.get(nums[i]);
                cnt--;
                if (cnt <= 0) occ.remove(nums[i]);
                else occ.put(nums[i], cnt);
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}