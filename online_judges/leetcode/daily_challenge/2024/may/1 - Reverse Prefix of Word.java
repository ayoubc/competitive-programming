class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) return word;

        char[] chars = word.toCharArray();
        int n = index + 1;
        for (int i=0;i<n/2;i++) {
            char c = chars[i];
            chars[i] = chars[n-1-i];
            chars[n-1-i] = c;
        }
        return new String(chars);
    }
}