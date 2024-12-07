class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        return Arrays.stream(nums).boxed()
                .sorted((x, y) -> Integer.compare(getMappedVal(x, mapping), getMappedVal(y, mapping)))
                .mapToInt(Integer::intValue).toArray();
    }
    private int getMappedVal(int x, int[] mapping) {
        if (x == 0) return mapping[x];
        int res = 0;
        int p = 1;
        while (x > 0) {
            res += p * mapping[x % 10];
            p *= 10;
            x /= 10;
        }
        //System.out.println(res);
        return res;
    }
}