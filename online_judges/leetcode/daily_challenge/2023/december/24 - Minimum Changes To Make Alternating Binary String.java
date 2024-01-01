class Solution {
    public int minOperations(String s) {
        return Math.min(solve(s, '1'), solve(s, '0'));
    }
    private int solve(String s, char start) {
        char[] arr = s.toCharArray();
        int cnt = 0;
        char prev = start;
        for(int i=0;i<arr.length;i++) {
            if (prev == arr[i]) {
                cnt++;
                prev = (char)(('1' - arr[i]) + '0');
            }
            else prev = arr[i];
        }
        return cnt;
    }
}