class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] pre = new int[n];
        pre[0] = nums[0];
        for(int i=1;i<n;i++) pre[i] = pre[i-1] + nums[i];
        for(int i=0;i<n;i++) {

            ans[i] = pre[n-1] - (i == 0? 0 : pre[i-1]) - pre[i] + (2 * i - n+1) * nums[i];
        }
        return ans;
    }
    // 0, 1, 3, 4, ... i, i+1, .... n-1
    // result[i] = 
    // nums[i]-nums[0] + nums[i]-nums[1] + ... + nums[i]-nums[i-1] + nums[i+1] - nums[i] + ... + nums[n-1] - nums[i]
    // i * nums[i] - presum[i-1] + (presum[n-1] - presum[i] - (n-1 - i) * nums[i]) 
    // presum[n-1] - presum[i-1] - presum[i] + (2 * i - n+1) * nums[i]
}