class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x:nums) set.add(x);
        int ans = -1;
        for (int x:nums) {
            if (x > 0 && set.contains(-x)) ans = Math.max(ans, x);
        }
        return ans;
    }
}