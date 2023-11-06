class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Comparator<Integer> comparator = new CustomComparator();
        Arrays.sort(nums, comparator);
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }

    private class CustomComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            int c = Integer.compare(Integer.bitCount(a), Integer.bitCount(b));
            if (c == 0) {
                c = Integer.compare(a, b);
            }
            return c;
        }
    }
}