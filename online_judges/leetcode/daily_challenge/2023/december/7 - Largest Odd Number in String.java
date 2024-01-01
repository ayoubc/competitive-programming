class Solution {
    public String largestOddNumber(String num) {
        int lastOdd = -1;
        for(int i=0;i<num.length();i++) {
            int d = num.charAt(i) - '0';
            if (d % 2 != 0) lastOdd = i;
        }
        return num.substring(0, lastOdd+1);
    }
}