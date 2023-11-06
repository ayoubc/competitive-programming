class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        //P[] pairs = new P[n];
        //for(int i=0;i<n;i++) pairs[i] = new P(i, nums[i]);
        //Arrays.sort(pairs, (p1, p2) -> -Integer.compare(cost[p1.i], cost[p2.i]));
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            l = Math.min(l, nums[i]);
            r = Math.max(r, nums[i]);
        }
        long ans = 0;
        while (l < r) {
            int mid = (l + r) / 2;
            long x1 = f(mid, nums, cost);
            long x2 = f(mid + 1, nums, cost);
            
            if (x1 < x2) {
                r = mid;
                ans = x1;
            }
            else {
                l = mid + 1;
                ans = x2;
            }
            
        }
        return ans;
    }
    public long f(int x, int[] nums, int[] cost) {
        long res = 0;
        for(int j=0;j<nums.length;j++) {
            res += ((long) cost[j]) * ((long)Math.abs(nums[j] - x));
        }
        return res;
    }
}