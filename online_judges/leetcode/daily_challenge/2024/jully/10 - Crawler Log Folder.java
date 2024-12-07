class Solution {
    public int minOperations(String[] logs) {
        int level = 1;
        for(String s:logs) {
            if (s.startsWith("..")) {
                if (level > 1) level --;
            }
            if (s.charAt(0) != '.') level++;
        }
        return level - 1;
    }
}