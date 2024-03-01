class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = n / 3;
        int[][] ans = new int[m][3];
        int j = 0;
        for(int i=0;i<n;i+=3){
            for(int l=0;l<3;l++) {
                ans[j][l] = nums[i+l];
            }
            if (nums[i+2] - nums[i] > k) return new int[][]{};
            j++;
        }
        return ans;
    }
}