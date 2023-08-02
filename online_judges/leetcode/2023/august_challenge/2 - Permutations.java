class Solution {
    private static List<List<Integer>> perms; 
    public List<List<Integer>> permute(int[] nums) {
        perms = new ArrayList<>();
        permutations(nums, 0);
        return perms;
    }
    private void permutations(int[] nums, int idx) {
        if (idx == nums.length-1) {
            List<Integer> list = IntStream.of(nums).boxed().collect(Collectors.toList());
            perms.add(list);
            return;
        }
        for(int i=idx+1; i<nums.length;i++) {
            swap(idx, i, nums);
            permutations(nums, idx+1);
            swap(i, idx, nums);
        }
        permutations(nums, idx+1);
    }
    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}