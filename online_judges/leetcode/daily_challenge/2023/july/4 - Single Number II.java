class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> set : mp.entrySet()) {
            if (set.getValue() == 1) {
                ans = set.getKey();
                break;
            }
            
        }
        return ans;
    }
}