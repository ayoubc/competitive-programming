class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int l = 0;
        int r = position[n-1];
        int ans = 0;
        while (l<r) {
            int mid = l + (r - l) / 2;
            if (ok(mid, m, position)) {
                ans = mid;
                l = mid + 1;
            }
            else r = mid;
        }
        return ans;
    }
    private int binarySeach(int[] nums, int s, int e, int v) {
        int index = e+1;
        int l = s;
        int r = e;
        while(l<=r){
            int mid =  (r + l) / 2;
            if (nums[mid]>=v){
                index = mid;
                r = mid-1;
            }
            else l = mid + 1;
        }
        return index;
    }
    private boolean ok(int x, int m, int[] nums) {
        int i = 0;
        int n = nums.length;
        int cnt = 1;
        while (i<n) {
            i = binarySeach(nums, i, n-1, nums[i]+x);
            if (i < n) cnt++;
        }
        return cnt >= m;
    }
}