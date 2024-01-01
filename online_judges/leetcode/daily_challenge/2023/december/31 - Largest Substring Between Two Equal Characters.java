class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int ans = -1;
        int[] prev = new int[26];
        Arrays.fill(prev, -1);
        for(int i=0;i<s.length();i++) {
            int d = prev[s.charAt(i) - 'a'];
            if (d != -1) ans = Math.max(ans, i - d - 1);
            else prev[s.charAt(i) - 'a'] = i;
        }
        return ans;
    }
}