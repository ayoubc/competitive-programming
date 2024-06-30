class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        
        Map<Integer, Integer> occ = new HashMap<>();
        int sum = 0;
        for(int i=0;i<n;i++) {
            sum += nums[i];
            int d = sum % k;
            if (d == 0 && i >= 1) return true;
            int j = occ.getOrDefault(d, -1);
            if (j != -1 && i - j >= 2) return true;
            if (j == -1) occ.put(d, i);
        }
        return false;
    }
}