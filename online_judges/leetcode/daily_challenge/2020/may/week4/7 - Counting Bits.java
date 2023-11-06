class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        ans[0] = 0;
        if (num == 0 ) return ans;
        ans[1] = 1;
        int k = 0;
        for(int i=2;i<=num;i++){
            if(isPowerOfTwo(i)) {
                k++;
                ans[i] = 1;
            }
            else if(i < (3 << (k-1))) ans[i] = ans[i - (1 << (k-1))];
            else ans[i] = ans[i - (1 << (k-1))] + 1;
        }
        return ans;
    }
    
    public boolean isPowerOfTwo(int x) {
        int p = x & (x - 1);
        return p == 0;
    }
}