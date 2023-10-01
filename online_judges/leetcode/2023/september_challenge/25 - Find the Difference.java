class Solution {
    public char findTheDifference(String s, String t) {
        int[] occs = new int[26];
        int[] occt = new int[26];
        countOcc(s, occs);
        countOcc(t, occt);
        int ans = -1;
        for(int i=0;i<26;i++) {
            if(occt[i] - occs[i] == 1) {
                ans = i;
                break;
            }
        }
        return (char)(ans + 'a');
    }

    private void countOcc(String s, int[] occ) {
        for(int i=0;i<s.length(); i++) {
            occ[s.charAt(i) - 'a'] ++;
        }
    }
}