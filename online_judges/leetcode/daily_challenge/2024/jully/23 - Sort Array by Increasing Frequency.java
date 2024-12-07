class Solution {
    public int[] frequencySort(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> occ = new HashMap<>();
        for(int x:nums) {
            occ.put(x, occ.getOrDefault(x,0)+1);
            ans.add(x);
        }
        ans.sort((a, b) -> {
            int c = Integer.compare(occ.get(a), occ.get(b));
            if (c == 0) c = Integer.compare(a, b) * -1;
            return c;
        });
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++) res[i] = ans.get(i);
        return res;
    }
}