class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        /*int i1 = 0;
        int str1 = 0;
        int i2 = 0;
        int str2 = 0;
        while (i1 < word1.length && i2 < word2.length) {
            if (word1[i1].charAt(str1) != word2[i2].charAt(str2)) return false;

            str1 ++;
            str2 ++;
            if (str1 >= word1[i1].length()) {
                str1 = 0;
                i1++;
            }
            if (str2 >= word2[i2].length()) {
                str2 = 0;
                i2++;
            }
        }
        if (i1 != word1.length || i2 != word2.length) return false;
        return true;
        */
        StringBuilder sd1 = new StringBuilder();
        StringBuilder sd2 = new StringBuilder();
        for(int i=0;i<word1.length;i++) sd1.append(word1[i]);
        for(int i=0;i<word2.length;i++) sd2.append(word2[i]);
        return sd1.toString().equals(sd2.toString());
    }
}