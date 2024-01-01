class Solution {
    public int findSpecialInteger(int[] arr) {
        int cnt = 1;
        int prev = arr[0];
        int n = arr.length;
        for(int i=1;i<n;i++) {
            if (cnt * 4 > n) break;
            if (prev == arr[i]) cnt ++;
            else {
                prev = arr[i];
                cnt = 1;
            }
        }
        return prev;
    }
}