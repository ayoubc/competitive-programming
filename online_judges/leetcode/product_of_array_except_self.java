class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] ans = new int[n];
        for(int i=0;i<n;i++) {
            if (i == 0) prefix[i] = nums[i];
            else {
                prefix[i] = nums[i] * prefix[i-1];
            }
        }
        for(int i=n-1;i>=0;i--) {
            if (i == n-1) suffix[i] = nums[i];
            else {
                suffix[i] = nums[i] * suffix[i+1];
            }
        }
        for(int i=0;i<n;i++) {
            if (i == 0) ans[i] = suffix[i+1];
            else if(i == n-1) ans[i] = prefix[i-1];
            else {
                ans[i] = prefix[i-1] * suffix[i+1];
            }
        }
        return ans;
        
    }
}