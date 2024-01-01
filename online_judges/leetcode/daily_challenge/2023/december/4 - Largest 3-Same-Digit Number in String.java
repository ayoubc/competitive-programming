class Solution {
    public String largestGoodInteger(String num) {
        String ans = "";
        for(int i=0;i+2<num.length();i++) {
            if (num.charAt(i) == num.charAt(i+1) && num.charAt(i+1) == num.charAt(i+2)) {
                String tmp = num.substring(i, i+3);
                if (ans.compareTo(tmp) < 0) ans = tmp;
            }
        }
        return ans;
    }
}