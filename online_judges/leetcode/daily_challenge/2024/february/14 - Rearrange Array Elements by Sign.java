class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for(int x:nums) {
            if(x > 0) pos.add(x);
            else neg.add(x);
        }
        for(int i=0;i<n;i++) {
            nums[i] = (i % 2 == 0 ? pos : neg).get(i/2);
        }
        return nums;
    }
}