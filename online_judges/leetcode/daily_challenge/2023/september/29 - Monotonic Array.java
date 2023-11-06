class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;
        int j = 1;
        while (j < n && nums[j] == nums[j-1]) j++;
        if (j >= n) return true;
        int sign = nums[j-1] <= nums[j] ? 1 : -1;
        for(int i=j;i<n;i++) {
            if (nums[i] == nums[i-1]) continue;
            int x =  nums[i-1] <= nums[i] ? 1 : -1;
            if (x != sign) {
                //System.out.println(i + " " + x);
                return false;
            }

        }
        return true;
    }
}