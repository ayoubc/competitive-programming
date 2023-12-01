class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        for(int i=1;i<n;i++) pre[i] += pre[i-1] + nums[i];


        int ans = 0;
        for(int i=0;i<n;i++) {
            int l = 0;
            int r = i;
            int d = i;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if ((i - mid + 1) * nums[i] - (pre[i] - (mid == 0 ? 0 : pre[mid-1])) <= k) {
                    r = mid - 1;
                    d = mid;
                }
                else l = mid + 1;
            }
            ans = Math.max(ans, i - d + 1);
        }

        return ans;

    }


}