class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] string = answerKey.toCharArray();
        int l = 1;
        int r = string.length;
        int ans = 1;
        while (l < r) {
            int mid = r - (r - l) / 2;
            if (isOk(mid, string, k)) {
                l = mid;
                ans = mid;
            }
            else r = mid - 1;
        }
        return ans;
    }
    private boolean isOk(int n, char[] string, int k) {
        
        int[] occ = new int[2];
        for(int i=0;i<n;i++) occ[getIndex(string[i])]++;
        if (Math.min(occ[0], occ[1]) <= k) return true;
        int l = 0;
        for(int r=n;r<string.length;r++) {
            occ[getIndex(string[l++])]--;
            occ[getIndex(string[r])]++;
            //System.out.println(n + " == " + r + " - " + l + " + 1");
            if (Math.min(occ[0], occ[1]) <= k) return true;
        }
        
        return false;
    }
    private int getIndex(char c) {
        return c == 'T' ? 1 : 0;
    }
}