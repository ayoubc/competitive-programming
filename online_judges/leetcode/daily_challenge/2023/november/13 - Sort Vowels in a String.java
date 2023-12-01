class Solution {
    private char[] vlower = new char[]{'a', 'e', 'i', 'o', 'u'};
    private char[] vupper = new char[]{'A', 'E', 'I', 'O', 'U'};
    public String sortVowels(String s) {
        List<Character> vs = new ArrayList<>();
        for(int i=0;i<s.length();i++) {
            if (isVowel(s.charAt(i)) != -1) vs.add(s.charAt(i));
        }
        Collections.sort(vs, (c1, c2) -> {
            return Integer.compare(isVowel(c1), isVowel(c2));
        });
        String ans = "";
        int j = 0;
        for(int i=0;i<s.length();i++) {
            if (isVowel(s.charAt(i)) != -1) {
                ans += vs.get(j);
                j++;
            }
            else ans += s.charAt(i);
        }
        return ans;
    }
    private int isVowel(char c) {
        for (int i=0;i<5;i++) {
            if (vlower[i] == c || vupper[i] == c) return c;
        }
        return -1;
    }
}