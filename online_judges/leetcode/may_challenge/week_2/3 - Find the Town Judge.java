class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] heTrust = new int[N+1];
        int[] trustsHim = new int[N+1];
        for(int i=0;i<trust.length;i++){
            trustsHim[trust[i][1]] ++;
            heTrust[trust[i][0]]++;
        }
        
        for(int i=1;i<=N;i++){
            if(trustsHim[i] == N-1 && heTrust[i] == 0) return i;
        }
        return -1;
    }
}