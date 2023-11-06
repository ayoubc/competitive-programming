class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int ans = -30000;
        int n = A.length;
        int m = 30000;
        int sum = 0;
        int local = 0;
        for(int i=0;i<n;i++){
            local = Math.max(A[i], local+A[i]);
            ans = Math.max(ans, local);
        }

        for(int i=0;i<n;i++) {
            A[i] *= -1;
            sum += A[i];
            m = Math.min(m, A[i]);
        }
        
        local = 0;
        int s = 0;
        for(int i=0;i<n;i++){
            local = Math.max(A[i], local+A[i]);
            s = Math.max(s, local);
        }
        
        ans = Math.max(-(sum - s), ans);
        
        return ans == 0 ? -m : ans;
    }
}