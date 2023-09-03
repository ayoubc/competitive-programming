class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while (columnNumber > 0) {
            int r = columnNumber % 26;
            r = r == 0 ? 26 : r;
            ans.append((char) ('A' + r - 1));
            columnNumber = (columnNumber - r) / 26;
        }
        return ans.reverse().toString();
    }
}