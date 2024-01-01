class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] occchars = new int[26];
        for(int i=0;i<chars.length();i++) occchars[chars.charAt(i) - 'a'] ++;

        int ans = 0;
        for(String word: words) {
            int[] occ = occchars.clone();
            boolean ok = true;
            for(int i=0;i<word.length();i++) {
                char c = word.charAt(i);
                if (occ[c - 'a'] == 0) {
                    ok = false;
                    break;
                }
                occ[c - 'a'] --;
            }
            if (ok) ans += word.length();
        }
        return ans;
    }
}