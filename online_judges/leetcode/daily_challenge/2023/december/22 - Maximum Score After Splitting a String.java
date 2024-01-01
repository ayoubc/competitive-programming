class Solution {
    public int maxScore(String s) {
        char[] arr = s.toCharArray();
        int totalOne = 0;
        for(char c: arr) totalOne += (c == '1' ? 1 : 0);
        int curZero = arr[0] == '0' ? 1 : 0;
        int curOne = arr[0] == '1' ? 1 : 0;
        int ans = totalOne - curOne + curZero;
        for(int i=1;i<arr.length-1;i++) {
            char c = arr[i];
            curZero += (c == '0' ? 1 : 0);
            curOne += (c == '1' ? 1 : 0);
            ans = Math.max(ans, totalOne - curOne + curZero);
        }
        return ans;
    }
}