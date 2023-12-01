class Solution {
    private static final int OO = 1000000007;
    public int countNicePairs(int[] nums) {
        Map<Integer, Long> occ = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int diff = nums[i] - rev(nums[i]);
            occ.put(diff, occ.getOrDefault(diff, 0L) + 1);
        }
        int ans = 0;
        for(Long d: occ.values()) {
            ans += (((d - 1) * d) / 2) % OO;
            ans %= OO;
        }
        return ans;
    }
    private int rev(int x) {
        int result = 0;
        while (x > 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }

        return result;
    }
}