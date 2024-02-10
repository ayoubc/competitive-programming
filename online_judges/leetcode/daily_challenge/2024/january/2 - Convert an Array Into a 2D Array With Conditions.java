class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        while(true) {
            Set<Integer> cur = new HashSet<>();
            for(int i=0;i<nums.length;i++) {
                if (nums[i] == -1) continue;
                if (!cur.contains(nums[i])) {
                    cur.add(nums[i]);
                    nums[i] = -1;
                }
            }
            if(cur.isEmpty()) break;
            ans.add(new ArrayList(cur));
        }
        return ans;
    }
}