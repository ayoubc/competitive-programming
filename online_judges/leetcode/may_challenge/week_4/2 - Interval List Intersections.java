class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> intersections = new ArrayList<>();
        for(int[] interA: A) {
            for(int[] interB: B) {
                if(Math.max(interA[0], interB[0]) <= Math.min(interA[1], interB[1])){
                    intersections.add(
                        new int[]{Math.max(interA[0], interB[0]), Math.min(interA[1], interB[1])});
                }
            }
        }
        int[][] ans = new int[intersections.size()][2];
        for(int i=0;i<intersections.size();i++) {
            ans[i] = intersections.get(i);
        }
        return ans;
    }
}