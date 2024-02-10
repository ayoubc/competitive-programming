class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        int n = nums.length;
        int[] occ = new int[n+1];
        for(int i=0;i<n;i++) occ[nums[i]]++;
        for(int x=1;x<=n;x++) {
            if (occ[x] == 0) ans[1] = x;
            if (occ[x] == 2) ans[0] = x;
        }
        return ans;
    }
}