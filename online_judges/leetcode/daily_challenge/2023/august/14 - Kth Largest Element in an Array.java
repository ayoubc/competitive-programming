class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int N = 10001;
        int[] occPos = new int[N];
        int[] occNeg = new int[N];
        for(int i=0;i<n;i++) {
            if (nums[i] < 0) occNeg[nums[i] * -1]++;
            else occPos[nums[i]]++;
        }

        int ans = -1;
        for(int i=N-1;i>=0;i--) {
            k = Math.max(0, k - occPos[i]);
            if(k == 0) {
                ans = i;
                break;
            } 
        }
        if (ans != -1) return ans;
        for(int i=1;i<N;i++) {
            k = Math.max(0, k - occNeg[i]);
            if(k == 0) {
                ans = i * -1;
                break;
            } 
        }
        return ans;
    }
}