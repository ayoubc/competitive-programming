class Solution {
    public long largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long ans = -1;
        long sum = nums[0] + nums[1];
        for(int i=2;i<n;i++) {
            if (nums[i] < sum) {
                ans = nums[i] + sum;
            }
            sum += nums[i];
        }
        return ans;
    }
}