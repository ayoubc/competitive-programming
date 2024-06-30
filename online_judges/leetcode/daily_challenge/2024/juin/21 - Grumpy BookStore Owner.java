class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = grumpy.length;
        int[] nog = new int[n];
        int[] withg = new int[n];
        for(int i=0;i<n;i++) {
            if (i == 0) {
                nog[i] = customers[i];
                withg[i] = customers[i] * (1 - grumpy[i]);
            }
            else {
                nog[i] = customers[i] + nog[i-1];
                withg[i] = customers[i] * (1 - grumpy[i]) + withg[i-1];
            }
        }
        int ans = 0;
        int maxs = 0;
        for(int i=0;i+minutes-1<n;i++){
            int j = i+minutes-1;
            int sum = nog[j] - (i == 0 ? 0 : nog[i-1]);
            int left = (i == 0 ? 0 : withg[i-1]);
            int right = withg[n-1] - withg[j];
            ans = Math.max(ans, sum + left + right);
        }

        return ans;
    }
}