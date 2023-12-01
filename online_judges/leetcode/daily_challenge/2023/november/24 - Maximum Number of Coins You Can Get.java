class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int i = 0;
        int j = piles.length-2;
        int ans = 0;
        while (j > i) {
            ans += piles[j];
            j -= 2;
            i ++;
        }
        return ans;
    }
}