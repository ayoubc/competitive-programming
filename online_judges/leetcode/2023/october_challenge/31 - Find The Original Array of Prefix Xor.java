class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;

        for(int i=n-1;i>=1;i--) {
            pref[i] ^=  pref[i-1];
        }
        return pref;
    }
}