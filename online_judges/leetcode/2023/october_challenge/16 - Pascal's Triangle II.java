class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[][] c = new Integer[rowIndex+1][rowIndex+1];
        c[0][0] = 1;
        for(int i=1;i<=rowIndex;i++) {
            c[i][0] = c[i][i] = 1;
            for(int j=1;j<i;j++) c[i][j] = c[i-1][j] + c[i-1][j-1];
        }
        return Arrays.asList(c[rowIndex]);
    }
}