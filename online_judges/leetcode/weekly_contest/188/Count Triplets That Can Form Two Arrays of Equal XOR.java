class Solution {
    public long[] preXor;
    public int countTriplets(int[] arr) {
        int n = arr.length;
        preXor = new long[n];
        preXor[0] = arr[0];
        for(int i=1;i<n;i++){
            preXor[i] = arr[i] ^ preXor[i-1];
        }
        
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j;k<n;k++){
                    long a = query(i, j-1);
                    long b = query(j, k);
                    if (a == b) ans++;
                }
            }
        }
        return ans;
    }
    
    public long query(int i, int j){
        if(i>0) return preXor[j] ^ preXor[i-1];
        return preXor[j];
    }
}