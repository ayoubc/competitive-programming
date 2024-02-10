class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> occ = new HashMap<>();
        for(int i=0;i<nums.length;i++) occ.put(nums[i], occ.getOrDefault(nums[i], 0)+1);
        int ans = 0;
        for(Map.Entry<Integer, Integer> entry: occ.entrySet()) {
            int rep = entry.getValue();
            if(rep == 1) return -1;
            int three = rep / 3;
            int r = rep % 3;
            if (r == 1) {
                three--;
                r += 3;
            }
            int two = r / 2;
            ans += three + two;
        }
        return ans;
    }
}