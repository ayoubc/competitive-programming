class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int cur = 0;
        for(int i=0;i<n;i++) {
            if(nums[i] % 2 == 0) {
                ans[cur++] = nums[i];
            }
        }
        for(int i=0;i<n;i++) {
            if(nums[i] % 2 == 1) {
                ans[cur++] = nums[i];
            }
        }
        return ans;
    }
}