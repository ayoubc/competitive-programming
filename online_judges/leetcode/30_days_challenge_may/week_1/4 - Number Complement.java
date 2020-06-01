class Solution {
    public int findComplement(int num) {
        String bin = Integer.toBinaryString(num);
        String xbin = "";
        for(int i=0;i<bin.length();i++) {
            char c = '1';
            if (bin.charAt(i) == '1') c = '0';
            
            xbin += c;
        }
        
        return Integer.parseInt(xbin, 2);
    }
}