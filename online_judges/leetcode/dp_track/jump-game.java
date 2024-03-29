class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];

        dp[0] = true;
        for(int i=1;i<n;i++) {
            for(int j=i-1;j>=0;j--) {
                if(i - j <= nums[j] && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n-1];
    }

}