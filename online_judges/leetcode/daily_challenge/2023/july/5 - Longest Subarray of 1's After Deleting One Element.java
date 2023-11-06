class Solution {
    public int longestSubarray(int[] nums) {
        List<Integer> ones = new ArrayList<>();
        int cnt = 0;
        int zero = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == 1) cnt++;
            else{
                ones.add(cnt);
                cnt = 0;
                zero++;
            }
        }
        if(cnt > 0) ones.add(cnt);
        int ans = 0;
        if (ones.size() == 1) {
            if (zero > 0) ans = ones.get(0);
            else ans = ones.get(0) - 1;
        }
        else {
            for(int i=0;i<ones.size()-1;i++) {
                ans = Math.max(ans, ones.get(i) + ones.get(i+1));
            }
        }
        return ans;
    }
}