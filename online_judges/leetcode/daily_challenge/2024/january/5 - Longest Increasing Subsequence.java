class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int x = 0;
        for(int i=0;i<n;i++) {
            ans[i] = 1;
            for(int j=0;j<i;j++) {
                if (nums[i] > nums[j]) ans[i] = Math.max(ans[i], ans[j]+1);
            }
            x = Math.max(x, ans[i]);
        }
        return x;
    }
}