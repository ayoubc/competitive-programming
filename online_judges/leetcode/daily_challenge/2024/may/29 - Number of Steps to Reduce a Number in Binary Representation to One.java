class Solution {
    public int numSteps(String s) {
        int ans = 0;
        char[] arr = s.toCharArray();
        int i = arr.length-1;
        while (i > 0) {
            if (arr[i] == '1') {
                arr[i] = '0';
                int j = i-1;
                while (j >= 0 && arr[j] == '1') {
                    arr[j] = '0';
                    j--;
                }
                if (j < 0) {
                    arr[0] = '1';
                    ans+=2;
                }
                else {
                    arr[j] = '1';
                    i--;
                    ans+=2;
                }
            }
            else {
                i--;
                ans++;
            }
        }
        return ans;
    }
}