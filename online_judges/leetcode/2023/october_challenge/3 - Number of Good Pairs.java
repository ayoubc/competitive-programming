class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] occ = new int[101];
        for(int i=0;i<nums.length;i++) {
            occ[nums[i]]++;
        }
        int ans = 0;
        for(int i=0;i<101;i++) {
            int n = occ[i];
            ans += ((n - 1) * n) / 2;
        }
        return ans;
    }
    
}