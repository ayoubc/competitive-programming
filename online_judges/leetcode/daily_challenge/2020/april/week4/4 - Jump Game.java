class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        while(q.size() > 0) {
            int i = q.poll();
            for(int j=1;j<=Math.min(nums[i], n - i -1);j++){
                if (!visited[i+j]) {
                    visited[i+j] = true;
                    q.add(i+j);
                }
            }
        }
        return visited[n - 1];
    }
}