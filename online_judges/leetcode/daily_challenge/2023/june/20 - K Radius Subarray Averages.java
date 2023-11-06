class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++) res[i] = -1;

        long curSum = 0;
        int i = 0;
        int j = 0;
        while (j < n) {
            curSum += nums[j];
            if (j - i == 2 * k) {
                res[i + k] = (int) (curSum / (2 * k + 1));
                curSum -= nums[i];
                i ++;
            }
            j ++;
        }


        // [7,4,3,9,1,8,5,2,6]
        //  0,1,2,3,4,5,6,7,8
        return res;
    }
}