class Solution {
    public int minDifference(int[] nums) {
        
        int n = nums.length;
        if (n < 4) return 0;
        Arrays.sort(nums);
        
        /*nums[n-1] - nums[3];
        nums[n-2] - nums[2];
        nums[n-3] - nums[1];
        nums[n-4] - nums[0];
        */
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<=3;i++) ans = Math.min(ans, nums[n-1-i] - nums[3-i]);
        return ans;
    }
}