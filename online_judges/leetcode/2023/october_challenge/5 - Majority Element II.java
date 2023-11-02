class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> occ = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++) {
            occ.put(nums[i], occ.getOrDefault(nums[i], 0) + 1);
        }
        Set<Integer> ans = new HashSet<>();
        for(int i=0;i<n;i++) {
            if (occ.get(nums[i]) > n / 3) ans.add(nums[i]);
        }
        return new ArrayList<>(ans);
    }
}