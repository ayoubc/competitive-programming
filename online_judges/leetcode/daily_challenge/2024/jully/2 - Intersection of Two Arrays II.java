class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] occ1 = new int[1001];
        int[] occ2 = new int[1001];
        for(int x:nums1) occ1[x]++;
        for(int x:nums2) occ2[x]++;
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<1001;i++) {
            for(int k=1;k<=Math.min(occ1[i], occ2[i]);k++) l.add(i);
        }
        int[] ans = new int[l.size()];
        int idx=0;
        for(Integer d:l) ans[idx++] = d;
        return ans;
    }
}