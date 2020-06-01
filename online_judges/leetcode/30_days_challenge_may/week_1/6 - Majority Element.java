class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> dict = new HashMap<>();
        for(int num:nums) {
            int x = 0;
            if (dict.containsKey(num)) {
                x = dict.get(num);
            }
            dict.put(num, x+1);
        }
        int ans = -1;
        for(int num: nums) {
            if (dict.get(num) * 2 > nums.length){
                ans = num;
                break;
            }
        }
        return ans;
    }
}