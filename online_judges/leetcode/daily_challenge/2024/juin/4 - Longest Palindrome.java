class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> occ = new HashMap<>();
        for (int i=0;i<s.length();i++) occ.put(s.charAt(i), occ.getOrDefault(s.charAt(i), 0)+1);
        int ans = 0;
        int odds = 0;
        for(Character c:occ.keySet()) {
            int o = occ.get(c);
            if (o % 2 == 0) ans += o;
            else {
                ans += o - 1;
                odds += 1;
            }
        }

        return ans + (odds >= 1 ? 1 : 0);
    }
}