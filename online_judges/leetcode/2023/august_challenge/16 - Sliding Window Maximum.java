class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) return nums;

        int[] ans = new int[nums.length - k + 1];
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> b.getKey()-a.getKey());
        
        for (int i=0;i<k;i++) {
            pq.add(new Pair<>(nums[i], i));
        }
        ans[0] = pq.peek().getKey();
        for(int i=k;i<nums.length;i++) {
            pq.add(new Pair(nums[i], i));
            while (true) {
                Pair<Integer, Integer> p = pq.peek();
                if (p.getValue() < i - k + 1) {
                    pq.poll();
                } 
                else {
                    ans[i - k + 1] = p.getKey();
                    break;
                }
            }
        }
        return ans;
    }
}