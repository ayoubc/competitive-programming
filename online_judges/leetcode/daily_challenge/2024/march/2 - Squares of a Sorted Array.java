class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++) {
            nums[i] *= nums[i];
        }
        int[] res = new int[n];
        int l = 0;
        int r = n-1;
        for(int i=n-1;i>=0;i--) {
            if (nums[l] <= nums[r]) {
                res[i] = nums[r];
                r--;
            }
            else {
                res[i] = nums[l];
                l++;
            }
        }
        return res;
    }
}