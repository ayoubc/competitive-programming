class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        List<Integer> nums = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        for(int x:arr) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
            nums.add(x);
        }
        nums.sort((x1, x2) -> {
            int c = Integer.compare(mp.get(x1), mp.get(x2));
            if (c == 0) c = Integer.compare(x1, x2);
            return c;
        });

        int cnt = 0;
        for(Integer x: nums) {
            if (cnt >= k) break;
            mp.put(x, mp.get(x)-1);
            cnt++;
            if (mp.get(x) == 0) mp.remove(x);
        }

        return mp.keySet().size();
    }
}