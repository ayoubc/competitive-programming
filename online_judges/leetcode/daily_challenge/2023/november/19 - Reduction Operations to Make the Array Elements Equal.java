class Solution {
    public int reductionOperations(int[] nums) {
        if (nums.length == 1) return 0;
        Arrays.sort(nums);
        int cnt = 1;
        int prev = 0;
        int ans = 0;
        for(int i=nums.length-1;i>=1;i--) {
            if (nums[i] == nums[0]) break;
            if (nums[i] == nums[i-1]) cnt++;
            else {
                ans += (prev + cnt);
                prev += cnt;
                cnt = 1;
            }
        }
        return ans;
    }
}