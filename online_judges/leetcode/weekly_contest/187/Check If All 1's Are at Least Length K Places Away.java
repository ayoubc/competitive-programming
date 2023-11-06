class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int i=-1;
        for(int j=0;j<nums.length;j++) {
            if (nums[j] == 1) {
                if (i!=-1) {
                    if (j - i - 1 < k) return false;
                }
                
                i = j;
            }
        }
        return true;
    }
}