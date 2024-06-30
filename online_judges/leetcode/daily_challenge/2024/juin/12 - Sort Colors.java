class Solution {
    public void sortColors(int[] nums) {
        int[] cnt = new int[3];
        for(int i=0;i<nums.length;i++) cnt[nums[i]]++;

        int cur = 0;
        for(int i=0;i<nums.length;){
            if (cnt[cur]<=0) {
                cur++;
            }
            else {
                cnt[cur]--;
                nums[i] = cur;
                i++;
            }
        }
    }
}