class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> occ = new HashMap<>();
        int sum = 0;
        int ans = 0;
        for(int i=0;i<n;i++) {
            sum += nums[i];
            int d = sum % k;
            if (d < 0) d += k;
            int j = occ.getOrDefault(d, 0);
            //System.out.println(sum + " " + d + " " + j);
            ans += j;
            if (d == 0) ans ++;
            occ.put(d, j+1);
        }
        return ans;
    }
}