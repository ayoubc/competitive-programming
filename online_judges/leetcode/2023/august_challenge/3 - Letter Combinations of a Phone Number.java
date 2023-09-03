class Solution {
    private static String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private static List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.length() == 0) return res;
        cartisianProducts(0, "", digits);
        return res;
    }
    private void cartisianProducts(int idx, String curS, String digits) {
        if (idx == digits.length()) {
            res.add(curS);
            return;
        }
        int d = digits.charAt(idx) - '0';
        String pS = map[d];
        for(int i=0;i<pS.length();i++) {
            cartisianProducts(idx+1, curS + pS.charAt(i), digits);
        } 
    }
}