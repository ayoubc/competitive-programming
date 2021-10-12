class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] pre = new int[n];
        pre[0] = nums[0];
        for(int i=1;i<n;i++){
            pre[i] = pre[i-1] + nums[i];
        }
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(1, 0);
        for(int i=1;i<n;i++){
            int tmp = 2 * pre[i] - i;
            int store = 2 * pre[i - 1] - i + 1;
            if(hm.containsKey(tmp)){
                ans = Math.max(ans, i - hm.get(tmp) + 1);
            }
            if (!hm.containsKey(store)){
                hm.put(store, i);
            }
        }
        return ans;
    }
}