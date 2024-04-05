class Solution {
    public String maximumOddBinaryNumber(String s) {
        String ones = "";
        String zeros = "";
        int taken = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c == '0') zeros += c;
            else {
                if (taken >= 1) ones += c;
                taken ++;
            }
        }
        return ones + zeros + '1';
    }
}