class Solution {
    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        for(int i=0;i<ss.length;i++) ss[i] = reverse(ss[i]);
        return String.join(" ", ss);
    }
    private String reverse(String s) {
        char[] tmp = s.toCharArray();
        String ans = "";
        for(int i=tmp.length - 1; i>=0;i--) ans += tmp[i];
        return ans;
    }
}