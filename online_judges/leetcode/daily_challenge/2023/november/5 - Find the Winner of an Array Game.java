class Solution {
    public int getWinner(int[] arr, int k) {
        int maxE = Integer.MIN_VALUE;
        
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<arr.length;i++) {
            maxE = Math.max(maxE, arr[i]);
            dq.addLast(arr[i]);
        }
        if (k >= arr.length-1) return maxE;
        int cnt = 0;
        int ans = -1;
        while(cnt < k) {
            int a = dq.removeFirst();
            int b = dq.removeFirst();
            int m = Math.min(a, b);
            int M = Math.max(a, b);
            
            if (ans == M || ans == -1) cnt++;
            else cnt = 1;
            ans = M;
            dq.addFirst(M);
            dq.addLast(m);
        } 
        return ans;
    }
}