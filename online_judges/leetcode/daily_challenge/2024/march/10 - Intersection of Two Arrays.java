class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> inter = new HashSet<>();
        Set<Integer> unic = new HashSet<>();
        for(int x:nums1) unic.add(x);
        for(int x:nums2) {
            if (unic.contains(x)) inter.add(x);
        }
        return inter.stream().mapToInt(x->x).toArray();
    }
}