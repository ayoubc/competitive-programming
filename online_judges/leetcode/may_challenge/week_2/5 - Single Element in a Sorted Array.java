class Solution {
    public int singleNonDuplicate(int[] nums) {
        int ans = -1;
        int n = nums.length;
        if (n == 1) return nums[0];
        ans = (nums[0] != nums[1] ? nums[0] : (nums[n-1] != nums[n-2] ? nums[n-1] : ans));
        
        for(int i=1;i<n-1;i++){
            if(nums[i] != nums[i-1] && nums[i] != nums[i+1]) {
                ans = nums[i];
                break;
            }
        }
        
        return ans;
    }
}