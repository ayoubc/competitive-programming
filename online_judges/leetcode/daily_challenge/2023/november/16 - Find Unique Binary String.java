class Solution {
    private String ans;
    public String findDifferentBinaryString(String[] nums) {
        ans = null;
        Set<String> set = new HashSet(Arrays.asList(nums));
        solve("", set);
        return ans;
    }
    private void solve(String s, Set<String> set){
        if (s.length() == set.size()) {
            if (!set.contains(s)) {
                ans = s;
                return;
            }
        }
        else if (ans == null) {
            solve(s+'0', set);
            solve(s+'1', set);
        }
    }
}